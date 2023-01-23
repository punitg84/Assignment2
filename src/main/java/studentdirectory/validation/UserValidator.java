package studentdirectory.validation;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.List;
import studentdirectory.models.User;

public class UserValidator {
  private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
  private static Validator validator = factory.getValidator();

  static void validateUser(User user) throws Exception {
//    Set<ConstraintViolation<Student>> violations = validator.validate(student);
//    for (ConstraintViolation<Student> violation : violations) {
//      errors.add(violation.getMessage());
//    }
  }

  static void validateAgeNumeric(String age) throws Exception{
//    if (!age.matches(IS_NUMERIC_REGEX)) {
//      errors.add("Age needs to be a numeric value");
//    }
  }

  static void validateCourses(List<String> courses) throws Exception{

  }

}
