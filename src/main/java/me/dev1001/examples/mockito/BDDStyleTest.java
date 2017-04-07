package me.dev1001.examples.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by hongzong.li on 7/17/16.
 */
public class BDDStyleTest {

  @Mock
  private MockitoService mockService;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test // BDD style
  public void testAlias() {
    // given
    given(mockService.call("ping")).willReturn("pong");

    // when
    String actual = mockService.call("ping");

    // then
    assertEquals("pong", actual);
  }
}
