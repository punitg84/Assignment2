package studentdirectory.controller;

import static studentdirectory.validation.UserValidator.validateAgeNumeric;
import static studentdirectory.validation.UserValidator.validateCourses;
import static studentdirectory.validation.UserValidator.validateUser;

import java.util.List;
import java.util.stream.Collectors;
import studentdirectory.enums.CourseType;
import studentdirectory.models.User;

public class UserController {
  public static User createUser(final String name,
                                final int age,
                                final String address,
                                final String rollNo,
                                final List<String> inputCourses) throws Exception {

    validateCourses(inputCourses);
    final List<CourseType> courseTypeList =
        inputCourses.stream().map(CourseType::valueOf).collect(Collectors.toList());

    final User user = new User(name, age, address, rollNo, courseTypeList);
    validateUser(user);

    return user;

  }
}
