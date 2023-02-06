package studentdirectory.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import studentdirectory.constants.Course;
import studentdirectory.models.User;

public final class UserValidator {

  private static final ValidatorFactory FACTORY = Validation.buildDefaultValidatorFactory();
  private static final Validator VALIDATOR = FACTORY.getValidator();

  private UserValidator() {

  }

  public static void validateUser(final User user) throws Exception {
    final Set<ConstraintViolation<User>> violations = VALIDATOR.validate(user);
    for (final ConstraintViolation<User> violation : violations) {
      throw new Exception(
          String.format("%1$s : value %2$s", violation.getMessage(), violation.getInvalidValue()));
    }
  }

  public static void validateCourses(final List<String> courses) throws Exception {
    final HashSet<String> coursesSet = new HashSet<>(courses);
    if (coursesSet.size() != Course.REQUIRED_LIMIT_FOR_USER) {
      throw new Exception(
          String.format("CourseName are required to be 4 distinct, current value: %s", courses));
    }
  }

}
