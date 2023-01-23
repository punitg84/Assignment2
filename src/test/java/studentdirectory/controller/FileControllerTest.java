package studentdirectory.controller;

import static org.junit.jupiter.api.Assertions.*;
import static studentdirectory.controller.FileController.readUserDetailsFromFile;
import static studentdirectory.controller.FileController.writeUserDetailsToFile;

import jakarta.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.controller.filecontrollertestcasestructure.ReadWriteUserDetailsToFileTestCaseStructure;
import studentdirectory.enums.Courses;
import studentdirectory.models.User;
import studentdirectory.models.UserCollection;

class FileControllerTest {

  private static Stream<ReadWriteUserDetailsToFileTestCaseStructure> generateTestCaseForReadWriteUserDetailsToFile() {
    //Test Case
    ReadWriteUserDetailsToFileTestCaseStructure testCase =
        new ReadWriteUserDetailsToFileTestCaseStructure();
    User firstUser =
        new User("User 1", 10, "address 1", "Roll No 1", Arrays.asList(Courses.A,Courses.B,Courses.C,Courses.D));
    User secondUser =
        new User("User 2", 18, "address 2", "Roll No 1", Arrays.asList(Courses.A,Courses.B,Courses.C,Courses.D));
    testCase.addUser(firstUser);
    testCase.addUser(secondUser);
    testCase.setTestCaseName("Adding user in file and then reading them");

    return Stream.of(testCase);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForReadWriteUserDetailsToFile")
  void testReadWriteUserDetailsToFile(ReadWriteUserDetailsToFileTestCaseStructure testCase) {
    UserCollection userCollection = UserCollection.getInstance();
    for(User user:testCase.getUserList()){
      userCollection.addUser(user);
    }
    writeUserDetailsToFile();
    List<User> oldData = new ArrayList<>(userCollection.getUserList());
    userCollection.clearUserList();
    readUserDetailsFromFile();
    List<User> newData = new ArrayList<>(userCollection.getUserList());
    assertEquals(oldData, newData, testCase.getTestCaseName());
  }
}