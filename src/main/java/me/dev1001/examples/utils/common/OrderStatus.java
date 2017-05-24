package me.dev1001.examples.utils.common;

/**
 * Created by hongzong.li on 5/24/17.
 */
public enum OrderStatus implements EnumConverter<OrderStatus, Integer> {
  CREATED(1), PAYING(2), SUCCEED(3), FAILED(4);

  private final int status;

  private static final ReverseEnumMap<OrderStatus, Integer> reverseMap =
      new ReverseEnumMap<>(OrderStatus.class);

  OrderStatus(int status) {
    this.status = status;
  }

  @Override
  public Integer get() {
    return status;
  }

  public static OrderStatus of(Integer status) {
    return reverseMap.get(status);
  }
}
