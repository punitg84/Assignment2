package studentdirectory.controller;

import static org.junit.jupiter.api.Assertions.*;
import static studentdirectory.utils.File.readObjectFromFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.controller.filecontrollertestscenario.ReadWriteToFileTestScenario;
import studentdirectory.models.User;
import studentdirectory.models.UserCollection;
import studentdirectory.utils.File;

class FileTest {

  private static Stream<ReadWriteToFileTestScenario> generateTestCaseForReadWriteUserDetailsToFile() {
    User firstUser = User.builder()
        .name("User 1")
        .age(10)
        .address("address 1")
        .rollNo("Roll No 1")
        .courses(new ArrayList<>())
        .build();
    User secondUser = User.builder()
        .name("User 2")
        .age(18)
        .address("address 2")
        .rollNo("Roll No 2")
        .courses(new ArrayList<>())
        .build();

    //Test Case

    ReadWriteToFileTestScenario testCase = ReadWriteToFileTestScenario.builder()
        .userList(Arrays.asList(firstUser, secondUser))
        .testCaseName("Adding user in file and then reading them")
        .errMessage("")
        .build();

    return Stream.of(testCase);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForReadWriteUserDetailsToFile")
  void testReadWriteUserDetailsToFile(ReadWriteToFileTestScenario testCase) {
    try {
      UserCollection userCollection = UserCollection.getInstance();
      for (User user : testCase.getUserList()) {
        userCollection.addUser(user);
      }
      File.writeObjectToFile(userCollection.getUserList());
      List<User> oldData = new ArrayList<>(userCollection.getUserList());
      userCollection.clearUserList();
      List<User> newData = (List<User>) readObjectFromFile();
      assertEquals(oldData, newData, testCase.getTestCaseName());
    } catch (Exception e) {
      assertEquals(testCase.getErrMessage(), e.getMessage(), testCase.getTestCaseName());
    }
  }

  @AfterEach
  void cleanup() throws Exception {

    UserCollection.getInstance().clearUserList();
  }

}