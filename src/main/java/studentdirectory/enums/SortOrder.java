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

  private static final Map<Integer, SortOrder> lookup = new HashMap<Integer, SortOrder>();

  private final int code;

  static {
    for (SortOrder order : EnumSet.allOf(SortOrder.class)) {
      lookup.put(order.getCode(), order);
    }
  }

  SortOrder(int code) {
    this.code = code;
  }

  private int getCode() {
    return code;
  }

  public static SortOrder get(int code) {
    return lookup.get(code);
  }
}
