package studentdirectory.validation;

import static studentdirectory.constants.Regex.IS_NUMERIC_REGEX;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import studentdirectory.constants.Course;
import studentdirectory.enums.Courses;
import studentdirectory.models.User;

public final class UserValidator {
  private static final ValidatorFactory FACTORY = Validation.buildDefaultValidatorFactory();
  private static final Validator VALIDATOR = FACTORY.getValidator();

  private UserValidator() {

  }

  public static void validateUser(final User user) throws Exception {
    final Set<ConstraintViolation<User>> violations = VALIDATOR.validate(user);
    for (final ConstraintViolation<User> violation : violations) {
      throw new Exception(violation.getMessage());
    }
  }

  public static void validateAgeNumeric(final String age) throws Exception {
    if (!age.matches(IS_NUMERIC_REGEX)) {
      throw new Exception("Age needs to be a numeric value");
    }
  }

  public static void validateCourses(final List<String> courses) throws Exception {
    final HashSet<String> coursesSet = new HashSet<>(courses);
    if (coursesSet.size() != Course.REQUIRED_LIMIT_FOR_USER) {
      throw new Exception("Courses are required to be 4 distinct");
    }
    try {
      courses.stream().forEach(Courses::valueOf);
    } catch (Exception e) {
      throw new Exception("Courses are need to have the following values only: A,B,C,D,E and F");
    }
  }
}
