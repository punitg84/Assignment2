package studentdirectory.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static studentdirectory.validation.UserCollectionValidator.validateRollNoPresent;
import static studentdirectory.validation.UserCollectionValidator.validateRollNoAbsent;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.enums.CourseType;
import studentdirectory.models.User;
import studentdirectory.models.UserCollection;
import studentdirectory.validation.usercollectionvalidatortestscenario.ValidateRollNoTestScenario;

class UserCollectionValidatorTest {

  private static Stream<ValidateRollNoTestScenario> generateTestCaseForValidateRollNoPresent() {

    User user = User.builder()
        .name("User 1")
        .age(10)
        .address("address 1 is a long address")
        .rollNo("192")
        .courses(Arrays.asList(CourseType.A, CourseType.B, CourseType.C, CourseType.D))
        .build();

    //Test Case 1 non duplicate users
    ValidateRollNoTestScenario testCase1 = ValidateRollNoTestScenario.builder()
        .userList(Arrays.asList(user))
        .rollNo("rollNo 2")
        .errMessage("Roll No is not present in the database")
        .testCaseName("Duplicate Doesn't Exist")
        .build();

    //Test Case 2 duplicate users
    ValidateRollNoTestScenario testCase2 = ValidateRollNoTestScenario.builder()
        .userList(Arrays.asList(user))
        .rollNo("192")
        .errMessage("")
        .testCaseName("Duplicate Exist")
        .build();

    return Stream.of(testCase1, testCase2);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForValidateRollNoPresent")
  void testValidateRollNoPresent(ValidateRollNoTestScenario testCase) {

    UserCollection userCollection = UserCollection.getInstance();
    for (User user : testCase.getUserList()) {
      userCollection.addUser(user);
    }
    try {
      validateRollNoPresent(testCase.getRollNo());
      assertEquals(testCase.getErrMessage(), "", testCase.getTestCaseName());
    } catch (Exception e) {
      assertEquals(testCase.getErrMessage(), e.getMessage(), testCase.getTestCaseName());
    }
  }

  private static Stream<ValidateRollNoTestScenario> generateTestCaseForValidateRollNoAbsent() {

    User user = User.builder()
        .name("User 1")
        .age(10)
        .address("address 1 is a long address")
        .rollNo("192")
        .courses(Arrays.asList(CourseType.A, CourseType.B, CourseType.C, CourseType.D))
        .build();

    //Test Case 1 non duplicate users
    ValidateRollNoTestScenario testCase1 = ValidateRollNoTestScenario.builder()
        .userList(Arrays.asList(user))
        .rollNo("rollNo 2")
        .errMessage("")
        .testCaseName("Duplicate Doesn't Exist")
        .build();

    //Test Case 2 duplicate users
    ValidateRollNoTestScenario testCase2 = ValidateRollNoTestScenario.builder()
        .userList(Arrays.asList(user))
        .rollNo("192")
        .errMessage("Roll No is already present in the database")
        .testCaseName("Duplicate Exist")
        .build();

    return Stream.of(testCase1, testCase2);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForValidateRollNoAbsent")
  void testValidateRollNoAbsent(ValidateRollNoTestScenario testCase) {

    UserCollection userCollection = UserCollection.getInstance();
    for (User user : testCase.getUserList()) {
      userCollection.addUser(user);
    }
    try {
      validateRollNoAbsent(testCase.getRollNo());
      assertEquals(testCase.getErrMessage(), "", testCase.getTestCaseName());
    } catch (Exception e) {
      assertEquals(testCase.getErrMessage(), e.getMessage(), testCase.getTestCaseName());
    }
  }


  @AfterEach
  void cleanup() {
    //Clearing user collection
    UserCollection.getInstance().clearUserList();
  }

}