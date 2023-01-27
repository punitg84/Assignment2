package studentdirectory.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum SortOrderType {

  AGE_ASC(1),
  AGE_DESC(2),
  NAME_ASC(3),
  NAME_DESC(4),
  ADDRESS_ASC(5),
  ADDRESS_DESC(6),
  ROLL_NO_ASC(7),
  ROLL_NO_DESC(8);

  public static final int NO_OF_SORT_OPTIONS = 8;

  private static final Map<Integer, SortOrderType> INTEGER_SORT_ORDER_MAP = new HashMap<>();

  private final int code;

  static {
    EnumSet.allOf(SortOrderType.class).stream().forEach(sortOrder -> INTEGER_SORT_ORDER_MAP.put(
        sortOrder.code, sortOrder));
  }

  SortOrderType(final int code) {
    this.code = code;
  }

  private int getCode() {
    return code;
  }

  public static SortOrderType get(final int code) throws Exception {

    if (!INTEGER_SORT_ORDER_MAP.containsKey(code)) {
      throw new Exception("No Sort Order type against give code");
    }

    return INTEGER_SORT_ORDER_MAP.get(code);

  }

}
