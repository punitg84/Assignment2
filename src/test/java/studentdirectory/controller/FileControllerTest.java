package studentdirectory.controller;

import static org.junit.jupiter.api.Assertions.*;
import static studentdirectory.controller.FileController.readUserDetailsFromFile;
import static studentdirectory.controller.FileController.writeUserDetailsToFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.controller.filecontrollertestscenario.ReadWriteUserDetailsToFileTestScenario;
import studentdirectory.enums.CourseType;
import studentdirectory.models.User;
import studentdirectory.models.UserCollection;

class FileControllerTest {

  private static Stream<ReadWriteUserDetailsToFileTestScenario> generateTestCaseForReadWriteUserDetailsToFile() {
    //Test Case
    ReadWriteUserDetailsToFileTestScenario testCase =
        new ReadWriteUserDetailsToFileTestScenario();
    User firstUser =
        new User("User 1", 10, "address 1", "Roll No 1",
            Arrays.asList(CourseType.A, CourseType.B, CourseType.C, CourseType.D));
    User secondUser =
        new User("User 2", 18, "address 2", "Roll No 1",
            Arrays.asList(CourseType.A, CourseType.B, CourseType.C, CourseType.D));
    testCase.setUserList(Arrays.asList(firstUser,secondUser));
    testCase.setTestCaseName("Adding user in file and then reading them");
    testCase.setErrMessage("");
    return Stream.of(testCase);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForReadWriteUserDetailsToFile")
  void testReadWriteUserDetailsToFile(ReadWriteUserDetailsToFileTestScenario testCase) {
    UserCollection userCollection = UserCollection.getInstance();
    for (User user : testCase.getUserList()) {
      userCollection.addUser(user);
    }
    try {
      writeUserDetailsToFile();
      List<User> oldData = new ArrayList<>(userCollection.getUserList());
      userCollection.clearUserList();
      readUserDetailsFromFile();
      List<User> newData = new ArrayList<>(userCollection.getUserList());
      assertEquals(oldData, newData, testCase.getTestCaseName());
    } catch (Exception e) {
      assertEquals(testCase.getErrMessage(), e.getMessage(), testCase.getTestCaseName());
    }
  }

  @AfterEach
  void cleanup(){
    UserCollection.getInstance().clearUserList();
  }
}