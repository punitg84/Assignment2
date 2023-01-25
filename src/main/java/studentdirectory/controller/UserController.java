package studentdirectory.controller;

import static studentdirectory.validation.UserValidator.validateAgeNumeric;
import static studentdirectory.validation.UserValidator.validateCourses;
import static studentdirectory.validation.UserValidator.validateUser;

import java.util.List;
import java.util.stream.Collectors;
import studentdirectory.enums.Courses;
import studentdirectory.models.User;

public class UserController {
  static User createUser(final String name, final String age, final String address,
                         final String rollNo,
                         final List<String> inputCourses) throws Exception {
    validateAgeNumeric(age);
    validateCourses(inputCourses);
    final int numericAge = Integer.parseInt(age);
    final List<Courses> coursesList =
        inputCourses.stream().map(Courses::valueOf).collect(Collectors.toList());
    final User user = new User(name, numericAge, address, rollNo, coursesList);
    validateUser(user);
    return user;
  }
}
