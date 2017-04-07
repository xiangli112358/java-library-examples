package me.dev1001.examples.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by hongzong.li on 7/17/16.
 */
public class MockitoStubTest {

  @Mock
  private MockitoService mockService;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testMockMethodReturnValue() {
    when(mockService.call("ping")).thenReturn("pong");
    assertEquals("pong", mockService.call("ping"));
    verify(mockService).call("ping");
  }

  @Test
  public void testMockMethodThrowException() {
    when(mockService.call("exception")).thenThrow(new RuntimeException());
    try {
      mockService.call("exception");
      fail();
    } catch (RuntimeException expected) {
      // expected.
    }
    verify(mockService).call("exception");
  }

  @Test
  public void testVerifyMockMethodCalledTimes() {
    mockService.call("once");
    mockService.call("twice");
    mockService.call("twice");
    mockService.call("three times");
    mockService.call("three times");
    mockService.call("three times");

    verify(mockService).call("once");
    verify(mockService, times(1)).call("once");
    verify(mockService, atMost(1)).call("once");

    verify(mockService, times(2)).call("twice");

    verify(mockService, times(3)).call("three times");
    verify(mockService, atLeast(3)).call("three times");
  }

  @Test
  public void testVerifyMockMethodInvocationOrder() {
    InOrder inOrder = inOrder(mockService);
    mockService.call("first");
    mockService.call("second");
    inOrder.verify(mockService).call("first");
    inOrder.verify(mockService).call("second");
  }

  @Test
  public void testConsecutiveCalls() {
    when(mockService.call("consecutive"))
        .thenThrow(new RuntimeException())
        .thenReturn("one", "two", "three");
    try {
      mockService.call("consecutive");
      fail();
    } catch (Exception expected) {
      // expected.
    }

    assertEquals("one", mockService.call("consecutive"));
    assertEquals("two", mockService.call("consecutive"));
    assertEquals("three", mockService.call("consecutive"));
    assertEquals("three", mockService.call("consecutive")); // always return the last result.

    verify(mockService, times(5)).call("consecutive");
  }

  @Test
  public void testAnswerCallback() {
    when(mockService.call(anyString())).then(
        invocationOnMock -> "args: " + Arrays.toString(invocationOnMock.getArguments()));
    assertEquals("args: [some arg]", mockService.call("some arg"));
  }

  @Test
  public void testStubVoidMethods() {
    doThrow(new RuntimeException()).when(mockService).run("exception");
    try {
      mockService.run("exception");
      fail();
    } catch (Exception expected) {
      // expected
    }
    verify(mockService).run("exception");
  }
}
