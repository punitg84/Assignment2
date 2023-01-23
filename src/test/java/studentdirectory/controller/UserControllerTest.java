package studentdirectory.controller;

import static org.junit.jupiter.api.Assertions.*;
import static studentdirectory.controller.UserController.createUser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.controller.usercontrollertestcasestructure.CreateUserTestCaseStructure;
import studentdirectory.models.User;

class UserControllerTest {

  private static Stream<CreateUserTestCaseStructure> generateTestCaseForCreateUser() {
    //Test Case 1 providing valid student
    CreateUserTestCaseStructure testCase1 =
        new CreateUserTestCaseStructure("User 1", "10", "Address 1", "192",
            Arrays.asList("A", "B", "C", "E"));
    testCase1.setErrMessage("");
    testCase1.setTestCaseName("Adding valid user");

    //Test Case 2 providing invalid student
    CreateUserTestCaseStructure testCase2 =
        new CreateUserTestCaseStructure("", "10", "Address 2", "193",
            Arrays.asList("A", "B", "C", "E"));
    testCase2.setErrMessage("Name cant be empty or null");
    testCase2.setTestCaseName("Adding invalid user with name empty");

    return Stream.of(testCase1, testCase2);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForCreateUser")
  void testCreateUser(CreateUserTestCaseStructure testCase) {
    String name = testCase.getName();
    String address = testCase.getAddress();
    String age = testCase.getAge();
    List<String> courses = testCase.getCourses();
    String rollNo = testCase.getRollNo();
    try{
      createUser(name,age,address,rollNo,courses);
      assertEquals(testCase.getErrMessage(),"",testCase.getTestCaseName());
    }catch(Exception e){
      assertEquals(testCase.getErrMessage(),e.getMessage(),testCase.getTestCaseName());
    }
  }
}