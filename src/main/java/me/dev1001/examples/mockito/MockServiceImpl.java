package me.dev1001.examples.mockito;

/**
 * Created by hongzong.li on 7/17/16.
 */
class MockServiceImpl implements MockitoService {

  @Override
  public void run(String arg) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String call(String arg) {
    return arg;
  }
}
