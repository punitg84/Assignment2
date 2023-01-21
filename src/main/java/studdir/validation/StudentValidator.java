package studdir.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import studdir.models.Student;

public class StudentValidator {
  private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
  private static Validator validator = factory.getValidator();

  static void validateStudent(Student student, List<String> errors) {
    Set<ConstraintViolation<Student>> violations = validator.validate(student);
    for (ConstraintViolation<Student> violation : violations) {
      errors.add(violation.getMessage());
    }
  }

  static void validateAgeNumeric(String age, List<String> errors){

  }

}
