package studentdirectory.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static studentdirectory.validation.UserCollectionValidator.validateRollNo;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.models.User;
import studentdirectory.models.UserCollection;
import studentdirectory.validation.usercollectionvalidatortestcasestructure.ValidateRollNoTestCaseStructure;

class UserCollectionValidatorTest {

  private static Stream<ValidateRollNoTestCaseStructure> generateTestCaseForValidateRollNo() {
    //Test Case 1 non duplicate users
    User user1 = new User("User 1", 10, "address 1", "rollNo 1",
        Arrays.asList("course 1", "course 2", "course 3", "course 4"));
    User newUser1 = new User("User 2", 10, "address 2", "rollNo 2",
        Arrays.asList("course 1", "course 2", "course 3", "course 4"));
    ValidateRollNoTestCaseStructure testCase1 = new ValidateRollNoTestCaseStructure();
    testCase1.addUserInUserList(user1);
    testCase1.setNewUser(newUser1);
    testCase1.setErrMessage("");
    testCase1.setTestCaseName("Duplicate Doesn't Exist");

    //Test Case 2 duplicate users
    User user2 = new User("User 1", 10, "address 1", "rollNo 1",
        Arrays.asList("course 1", "course 2", "course 3", "course 4"));
    User newUser2 = new User("User 2", 10, "address 2", "rollNo 1",
        Arrays.asList("course 1", "course 2", "course 3", "course 4"));
    ValidateRollNoTestCaseStructure testCase2 = new ValidateRollNoTestCaseStructure();
    testCase2.addUserInUserList(user2);
    testCase2.setNewUser(newUser2);
    testCase2.setErrMessage("Roll No Exist");
    testCase2.setTestCaseName("Duplicate Exist");

    return Stream.of(testCase1,testCase2);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForValidateRollNo")
  void testValidateRollNo(ValidateRollNoTestCaseStructure testCase) {
    UserCollection userCollection = UserCollection.getInstance();
    for (User user : testCase.getUserList()) {
      userCollection.addUser(user);
    }
    try {
      validateRollNo(testCase.getNewUser().getRollNo());
      assertEquals(testCase.getErrMessage(), "", testCase.getTestCaseName());
    } catch (Exception e) {
      assertEquals(testCase.getErrMessage(), e.getMessage(), testCase.getTestCaseName());
    }
  }

  @AfterEach
  void cleanup(){
    //Clearing user collection
    UserCollection.getInstance().clearUserList();
  }
}