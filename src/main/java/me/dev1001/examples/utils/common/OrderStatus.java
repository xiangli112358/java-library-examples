package me.dev1001.examples.utils.common;

/**
 * Created by hongzong.li on 5/24/17.
 */
public enum OrderStatus implements EnumConverter<OrderStatus, Integer> {
  CREATED(1), PAYING(2), SUCCEED(3), FAILED(4);

  private final int status;

  OrderStatus(int status) {
    this.status = status;
  }

  @Override
  public Integer convert() {
    return status;
  }
}
