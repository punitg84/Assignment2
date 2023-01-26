package studentdirectory.validation;

import static studentdirectory.constants.Regex.IS_NUMERIC_REGEX;
import static studentdirectory.enums.SortOrder.NO_OF_SORT_OPTIONS;

public final class InputValidator {

  private InputValidator() {

  }

  public static void validateSortOption(final String option) throws Exception {
    if (!option.matches(IS_NUMERIC_REGEX)) {
      throw new Exception("Option needs to have a numeric value");
    }
    final int integerOption = Integer.parseInt(option);
    if (integerOption < 1 || integerOption > NO_OF_SORT_OPTIONS) {
      throw new Exception("Option needs to lie between 1-8");
    }
  }

}
