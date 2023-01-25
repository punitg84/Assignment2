package studentdirectory.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum SortOrder {

  AGE_ASC(1),
  AGE_DESC(2),
  NAME_ASC(3),
  NAME_DESC(4),
  ADDRESS_ASC(5),
  ADDRESS_DESC(6),
  ROLL_NO_ASC(7),
  ROLL_NO_DESC(8);

  private static final Map<Integer, SortOrder> INTEGER_SORT_ORDER_MAP = new HashMap<>();

  private final int code;

  static {
    for (final SortOrder order : EnumSet.allOf(SortOrder.class)) {
      INTEGER_SORT_ORDER_MAP.put(order.getCode(), order);
    }
  }

  SortOrder(final int code) {
    this.code = code;
  }

  private int getCode() {
    return code;
  }

  public static SortOrder get(final int code) {
    return INTEGER_SORT_ORDER_MAP.get(code);
  }
}
