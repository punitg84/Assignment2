package studentdirectory.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.controller.usercontrollertestscenario.CreateUserTestScenario;
import studentdirectory.models.UserCollection;

class UserControllerTest {

  private static Stream<CreateUserTestScenario> generateTestCaseForCreateUser() {
    //Test Case 1 providing valid student
    CreateUserTestScenario testCase1 = CreateUserTestScenario.builder()
        .name("User 1")
        .age(10)
        .address("Address 1 is a long value")
        .rollNo("192")
        .courses(Arrays.asList("A", "B", "C", "E"))
        .errMessage("")
        .testCaseName("Adding valid user")
        .build();

    //Test Case 2 providing invalid student
    CreateUserTestScenario testCase2 = CreateUserTestScenario.builder()
        .name("")
        .age(10)
        .address("Address 1 is a long value")
        .rollNo("193")
        .courses(Arrays.asList("A", "B", "C", "E"))
        .errMessage("Name cant be empty or null")
        .testCaseName("Adding invalid user with name empty")
        .build();

    return Stream.of(testCase1, testCase2);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForCreateUser")
  void testCreateUser(CreateUserTestScenario testCase) {
    UserController userController = new UserController(new UserCollectionRepo(UserCollection.getInstance()));
    String name = testCase.getName();
    String address = testCase.getAddress();
    int age = testCase.getAge();
    List<String> courses = testCase.getCourses();
    String rollNo = testCase.getRollNo();
    try {
      userController.createUser(name, age, address, rollNo, courses);
      assertEquals(testCase.getErrMessage(), "", testCase.getTestCaseName());
    } catch (Exception e) {
      assertEquals(testCase.getErrMessage(), e.getMessage(), testCase.getTestCaseName());
    }
  }

}