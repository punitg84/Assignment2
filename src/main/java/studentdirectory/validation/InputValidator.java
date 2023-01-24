package studentdirectory.validation;

import static studentdirectory.constants.Regex.IS_NUMERIC_REGEX;

public class InputValidator {
  public static void sortOptionValidator(String option) throws Exception {
    if (!option.matches(IS_NUMERIC_REGEX)) {
      throw new Exception("Option needs to have a numeric value");
    }
    int integerOption = Integer.parseInt(option);
    if (integerOption < 1 || integerOption > 8) {
      throw new Exception("Option needs to lie between 1-8");
    }
  }
}
