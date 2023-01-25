package studentdirectory.validation;

import static org.junit.jupiter.api.Assertions.*;
import static studentdirectory.validation.UserValidator.validateAgeNumeric;
import static studentdirectory.validation.UserValidator.validateCourses;
import static studentdirectory.validation.UserValidator.validateUser;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.enums.Courses;
import studentdirectory.models.User;
import studentdirectory.validation.uservalidatortestscenario.ValidateAgeNumericTestScenario;
import studentdirectory.validation.uservalidatortestscenario.ValidateCoursesTestScenario;
import studentdirectory.validation.uservalidatortestscenario.ValidateUserTestScenario;

class UserValidatorTest {
  private static Stream<ValidateUserTestScenario> generateTestCaseForValidateUser() {
    //Test Case 1 age negative
    User user1 = new User("User 1", -10, "address 1 is of more than 10 characters", "rollNo 1",
        Arrays.asList(Courses.A, Courses.B, Courses.C, Courses.D));
    ValidateUserTestScenario testCase1 = new ValidateUserTestScenario();
    testCase1.setUser(user1);
    testCase1.setErrMessage("Age should not be less than 3");
    testCase1.setTestCaseName("Age negative");

    //Test Case 2 name empty
    User user2 = new User("", 10, "address 1 is longer than 10 characters", "rollNo 1",
        Arrays.asList(Courses.A, Courses.B, Courses.C, Courses.F));
    ValidateUserTestScenario testCase2 = new ValidateUserTestScenario();
    testCase2.setUser(user2);
    testCase2.setErrMessage("Name cant be empty or null");
    testCase2.setTestCaseName("Empty name");

    //Test Case 3 valid user
    User user3 = new User("Punit", 10, "address 1", "rollNo 1",
        Arrays.asList(Courses.A, Courses.B, Courses.C, Courses.D));
    ValidateUserTestScenario testCase3 = new ValidateUserTestScenario();
    testCase3.setUser(user3);
    testCase3.setErrMessage(
        "Address must be longer than 10 characters but less than 50 characters");
    testCase3.setTestCaseName("Valid user");

    return Stream.of(testCase1, testCase2, testCase3);
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

  private static Stream<ValidateAgeNumericTestScenario> generateTestCaseForValidateAgeNumeric() {
    //Test Case 1 non integral value
    ValidateAgeNumericTestScenario testCase1 = new ValidateAgeNumericTestScenario();
    testCase1.setAge("random");
    testCase1.setErrMessage("Age needs to be a numeric value");
    testCase1.setTestCaseName("Non integral value");

    //Test Case 2 integral value
    ValidateAgeNumericTestScenario testCase2 = new ValidateAgeNumericTestScenario();
    testCase2.setAge("5");
    testCase2.setErrMessage("");
    testCase2.setTestCaseName("integral value");

    return Stream.of(testCase1, testCase2);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForValidateAgeNumeric")
  void testValidateAgeNumeric(ValidateAgeNumericTestScenario testCase) {
    try {
      validateAgeNumeric(testCase.getAge());
      assertEquals(testCase.getErrMessage(), "", testCase.getTestCaseName());
    } catch (Exception e) {
      assertEquals(testCase.getErrMessage(), e.getMessage(), testCase.getTestCaseName());
    }
  }

  private static Stream<ValidateCoursesTestScenario> generateTestCaseForValidateCourses() {
    //Test Case 1 less than 4 courses
    ValidateCoursesTestScenario testCase1 = new ValidateCoursesTestScenario();
    testCase1.setCourses(Arrays.asList("A", "B", "C", "C"));
    testCase1.setErrMessage("Courses are required to be 4 distinct");
    testCase1.setTestCaseName("Less than 4 courses");

    //Test Case 2 4 courses
    ValidateCoursesTestScenario testCase2 = new ValidateCoursesTestScenario();
    testCase2.setCourses(Arrays.asList("A", "B", "C", "F"));
    testCase2.setErrMessage("");
    testCase2.setTestCaseName("4 courses accurate");

    //Test Case 3 Invalid Courses
    ValidateCoursesTestScenario testCase3 = new ValidateCoursesTestScenario();
    testCase3.setCourses(Arrays.asList("A", "Random", "C", "F"));
    testCase3.setErrMessage("Courses are need to have the following values only: A,B,C,D,E and F");
    testCase3.setTestCaseName("Invalid Course");

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