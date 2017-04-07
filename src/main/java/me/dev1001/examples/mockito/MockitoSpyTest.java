package me.dev1001.examples.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * Created by hongzong.li on 7/17/16.
 */
public class MockitoSpyTest {

  @Spy
  private MockitoService mockService = new MockServiceImpl();

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testDefaultImpl() { // call on real objects.
    try {
      mockService.run("any thing");
      fail();
    } catch (UnsupportedOperationException expected) {
      // expected
    }

    assertEquals("hello", mockService.call("hello"));
  }

  @Test
  public void testChangePartialImpl() {
    doNothing().when(mockService).run(anyString());

    mockService.run("anything");

    // unmocked methods still remain old behaviour.
    assertEquals("hello", mockService.call("hello"));
  }
}
