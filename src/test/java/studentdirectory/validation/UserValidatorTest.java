package studentdirectory.validation;

import static org.junit.jupiter.api.Assertions.*;
import static studentdirectory.validation.UserValidator.validateCourses;
import static studentdirectory.validation.UserValidator.validateUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.models.Course;
import studentdirectory.models.User;
import studentdirectory.validation.uservalidatortestscenario.ValidateCoursesTestScenario;
import studentdirectory.validation.uservalidatortestscenario.ValidateUserTestScenario;

class UserValidatorTest {

  private static Stream<ValidateUserTestScenario> generateTestCaseForValidateUser()
      throws Exception {

    List<Course> courses = new ArrayList<>();
    for(String type:Arrays.asList("A","B","C","D")){
      courses.add(new Course(type));
    }

    User user1 = User.builder()
        .name("User 1")
        .age(-10)
        .address("address 1 is a long address")
        .rollNo("Roll No 1")
        .courses(courses)
        .build();
    User user2 = User.builder()
        .name("User 2")
        .age(18)
        .address("address 2 is a long address")
        .rollNo("Roll No 2")
        .courses(courses)
        .build();

    //Test Case 1 age negative
    ValidateUserTestScenario testCase1 = ValidateUserTestScenario.builder()
        .user(user1)
        .errMessage("Age should not be less than 3 : value -10")
        .testCaseName("Age negative")
        .build();

    //Test Case 2 valid user
    ValidateUserTestScenario testCase2 = ValidateUserTestScenario.builder()
        .user(user2)
        .errMessage("")
        .testCaseName("Valid User")
        .build();

    return Stream.of(testCase1, testCase2);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForValidateUser")
  void testValidateUser(ValidateUserTestScenario testCase) {

    try {
      validateUser(testCase.getUser());
      assertEquals(testCase.getErrMessage(), "", testCase.getTestCaseName());
    } catch (Exception e) {
      assertEquals(testCase.getErrMessage(), e.getMessage(), testCase.getTestCaseName());
    }
  }

  private static Stream<ValidateCoursesTestScenario> generateTestCaseForValidateCourses() {
    //Test Case 1 less than 4 courses
    ValidateCoursesTestScenario testCase1 = ValidateCoursesTestScenario.builder()
        .courses(Arrays.asList("A", "B", "C", "C"))
        .errMessage("CourseName are required to be 4 distinct, current value: [A, B, C, C]")
        .testCaseName("Less than 4 courses")
        .build();

    //Test Case 2 4 courses
    ValidateCoursesTestScenario testCase2 = ValidateCoursesTestScenario.builder()
        .courses(Arrays.asList("A", "B", "C", "F"))
        .errMessage("")
        .testCaseName("4 courses accurate")
        .build();

    return Stream.of(testCase1, testCase2);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForValidateCourses")
  void testValidateCourses(ValidateCoursesTestScenario testCase) {

    try {
      validateCourses(testCase.getCourses());
      assertEquals(testCase.getErrMessage(), "", testCase.getTestCaseName());
    } catch (Exception e) {
      assertEquals(testCase.getErrMessage(), e.getMessage(), testCase.getTestCaseName());
    }
  }

}