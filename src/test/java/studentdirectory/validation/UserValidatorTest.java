package studentdirectory.validation;

import static org.junit.jupiter.api.Assertions.*;
import static studentdirectory.validation.UserValidator.validateAgeNumeric;
import static studentdirectory.validation.UserValidator.validateCourses;
import static studentdirectory.validation.UserValidator.validateUser;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.models.User;
import studentdirectory.validation.uservalidatortestcasestructure.ValidateAgeNumericTestCaseStructure;
import studentdirectory.validation.uservalidatortestcasestructure.ValidateCoursesTestCaseStructure;
import studentdirectory.validation.uservalidatortestcasestructure.ValidateUserTestCaseStructure;

class UserValidatorTest {
  private static Stream<ValidateUserTestCaseStructure> generateTestCaseForValidateUser() {
    //Test Case 1 age negative
    User user1 = new User("User 1", -10, "address 1", "rollNo 1",
        Arrays.asList("course 1", "course 2", "course 3", "course 4"));
    ValidateUserTestCaseStructure
        testCase1 = new ValidateUserTestCaseStructure();
    testCase1.setUser(user1);
    testCase1.setErrMessage("negative age");
    testCase1.setTestCaseName("Age negative");

    //Test Case 2 name empty
    User user2 = new User("", -10, "address 1", "rollNo 1",
        Arrays.asList("course 1", "course 2", "course 3", "course 4"));
    ValidateUserTestCaseStructure
        testCase2 = new ValidateUserTestCaseStructure();
    testCase2.setUser(user2);
    testCase2.setErrMessage("name is empty");
    testCase2.setTestCaseName("Empty name");

    //Test Case 3 valid user
    User user3 = new User("", -10, "address 1", "rollNo 1",
        Arrays.asList("course 1", "course 2", "course 3", "course 4"));
    ValidateUserTestCaseStructure
        testCase3 = new ValidateUserTestCaseStructure();
    testCase3.setUser(user3);
    testCase3.setErrMessage("");
    testCase3.setTestCaseName("Valid user");

    return Stream.of(testCase1, testCase2, testCase3);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForValidateUser")
  void testValidateUser(ValidateUserTestCaseStructure testCase) {
    try {
      validateUser(testCase.getUser());
      assertEquals(testCase.getErrMessage(), "", testCase.getTestCaseName());
    } catch (Exception e) {
      assertEquals(testCase.getErrMessage(), e.getMessage(), testCase.getTestCaseName());
    }
  }

  private static Stream<ValidateAgeNumericTestCaseStructure> generateTestCaseForValidateAgeNumeric() {
    //Test Case 1 non integral value
    ValidateAgeNumericTestCaseStructure
        testCase1 = new ValidateAgeNumericTestCaseStructure();
    testCase1.setAge("random");
    testCase1.setErrMessage("Age is not an integer");
    testCase1.setTestCaseName("Non integral value");

    //Test Case 2 integral value
    ValidateAgeNumericTestCaseStructure
        testCase2 = new ValidateAgeNumericTestCaseStructure();
    testCase1.setAge("5");
    testCase1.setErrMessage("");
    testCase1.setTestCaseName("integral value");

    return Stream.of(testCase1,testCase2);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForValidateAgeNumeric")
  void testValidateAgeNumeric(ValidateAgeNumericTestCaseStructure testCase) {
    try {
      validateAgeNumeric(testCase.getAge());
      assertEquals(testCase.getErrMessage(), "", testCase.getTestCaseName());
    } catch (Exception e) {
      assertEquals(testCase.getErrMessage(), e.getMessage(), testCase.getTestCaseName());
    }
  }

  private static Stream<ValidateCoursesTestCaseStructure> generateTestCaseForValidateCourses() {
    //Test Case 1 less than 4 courses
    ValidateCoursesTestCaseStructure
        testCase1 = new ValidateCoursesTestCaseStructure();
    testCase1.setCourses(Arrays.asList("A", "B", "C", "C"));
    testCase1.setErrMessage("Courses are need to be 4 distinct ones");
    testCase1.setTestCaseName("Less than 4 courses");

    //Test Case 2 4 courses
    ValidateCoursesTestCaseStructure
        testCase2 = new ValidateCoursesTestCaseStructure();
    testCase2.setCourses(Arrays.asList("A", "B", "C", "F"));
    testCase2.setErrMessage("");
    testCase2.setTestCaseName("4 courses accurate");

    //Test Case 3 Invalid Courses
    ValidateCoursesTestCaseStructure
        testCase3 = new ValidateCoursesTestCaseStructure();
    testCase3.setCourses(Arrays.asList("A", "Random", "C", "F"));
    testCase3.setErrMessage("Courses are need to be A B C D E or F");
    testCase3.setTestCaseName("Invalid Course");

    return Stream.of(testCase1,testCase2,testCase3);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForValidateCourses")
  void testValidateCourses(ValidateCoursesTestCaseStructure testCase) {
    try {
      validateCourses(testCase.getCourses());
      assertEquals(testCase.getErrMessage(), "", testCase.getTestCaseName());
    } catch (Exception e) {
      assertEquals(testCase.getErrMessage(), e.getMessage(), testCase.getTestCaseName());
    }
  }
}