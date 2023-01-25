package studentdirectory.validation;

import static studentdirectory.constants.Course.NO_OF_COURSES_AVAILABLE;
import static studentdirectory.constants.Regex.IS_NUMERIC_REGEX;

public class InputValidator {
  public static void sortOptionValidator(final String option) throws Exception {
    if (!option.matches(IS_NUMERIC_REGEX)) {
      throw new Exception("Option needs to have a numeric value");
    }
    final int integerOption = Integer.parseInt(option);
    if (integerOption < 1 || integerOption > NO_OF_COURSES_AVAILABLE) {
      throw new Exception("Option needs to lie between 1-8");
    }
  }
}
