package studentdirectory.validation;

import static org.junit.jupiter.api.Assertions.*;
import static studentdirectory.validation.UserValidator.validateCourses;
import static studentdirectory.validation.UserValidator.validateUser;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.enums.CourseType;
import studentdirectory.models.User;
import studentdirectory.validation.uservalidatortestscenario.ValidateCoursesTestScenario;
import studentdirectory.validation.uservalidatortestscenario.ValidateUserTestScenario;

class UserValidatorTest {
  private static Stream<ValidateUserTestScenario> generateTestCaseForValidateUser() {

    User user1 = User.builder()
                .name("User 1")
                .age(-10)
                .address("address 1 is a long address")
                .rollNo("192")
                .courses(Arrays.asList(CourseType.A, CourseType.B, CourseType.C, CourseType.D))
                .build();

    User user2 = User.builder()
                .name("User 1")
                .age(10)
                .address("address 1 is a long address")
                .rollNo("192")
                .courses(Arrays.asList(CourseType.A, CourseType.B, CourseType.C, CourseType.D))
                .build();

    //Test Case 1 age negative
    ValidateUserTestScenario testCase1 = ValidateUserTestScenario.builder()
                                        .user(user1)
                                        .errMessage("Age should not be less than 3")
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
                                            .errMessage("CourseType are required to be 4 distinct")
                                            .testCaseName("Less than 4 courses")
                                            .build();

    //Test Case 2 4 courses
    ValidateCoursesTestScenario testCase2 = ValidateCoursesTestScenario.builder()
                                            .courses(Arrays.asList("A", "B", "C", "F"))
                                            .errMessage("")
                                            .testCaseName("4 courses accurate")
                                            .build();

    //Test Case 3 Invalid CourseType
    ValidateCoursesTestScenario testCase3 = ValidateCoursesTestScenario.builder()
                                            .courses(Arrays.asList("A", "Random", "C", "F"))
                                            .errMessage("CourseType are need to have the following values only: A,B,C,D,E and F")
                                            .testCaseName("Invalid Course")
                                            .build();

    return Stream.of(testCase1, testCase2, testCase3);
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