package studentdirectory.controller;

import static studentdirectory.validation.UserValidator.validateCourses;
import static studentdirectory.validation.UserValidator.validateUser;

import java.util.ArrayList;
import java.util.List;
import studentdirectory.models.Course;
import studentdirectory.models.User;

public final class UserController {

  private UserCollectionRepo userCollectionRepo;

  public UserController(final UserCollectionRepo userCollectionRepo) {
    this.userCollectionRepo = userCollectionRepo;
  }

  public void createUser(
      final String name,
      final int age,
      final String address,
      final String rollNo,
      final List<String> inputCourses) throws Exception {

    validateCourses(inputCourses);

    final List<Course> courses = new ArrayList<>();
    for (final String input : inputCourses) {
      courses.add(new Course(input));
    }

    final User user = User.builder()
        .name(name)
        .age(age)
        .address(address)
        .rollNo(rollNo)
        .courses(courses)
        .build();

    validateUser(user);

    userCollectionRepo.addUser(user);

  }

}
