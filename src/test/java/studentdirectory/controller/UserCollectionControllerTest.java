package studentdirectory.controller;

import static org.junit.jupiter.api.Assertions.*;
import static studentdirectory.controller.UserCollectionController.addUser;
import static studentdirectory.controller.UserCollectionController.deleteUser;
import static studentdirectory.controller.UserCollectionController.getUserListSortedByOrder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.controller.usercollectioncontrollertestscenario.AddUserTestScenario;
import studentdirectory.controller.usercollectioncontrollertestscenario.DeleteUserTestScenario;
import studentdirectory.controller.usercollectioncontrollertestscenario.GetUserListSortedByOrderTestScenario;
import studentdirectory.enums.CourseType;
import studentdirectory.enums.SortOrderType;
import studentdirectory.models.User;
import studentdirectory.models.UserCollection;

class UserCollectionControllerTest {

  private static Stream<AddUserTestScenario> generateTestCaseForAddUser() {
    //Test Case 1 providing valid student
    AddUserTestScenario testCase1 = AddUserTestScenario.builder()
        .name("User 1")
        .age(10)
        .address("Address 1 is a long value")
        .rollNo("192")
        .courses(Arrays.asList("A", "B", "C", "E"))
        .userListSize(1)
        .testCaseName("Adding valid user")
        .build();

    //Test Case 2 providing invalid student
    AddUserTestScenario testCase2 = AddUserTestScenario.builder()
        .name("User 2")
        .age(10)
        .address("Address 2")
        .rollNo("193")
        .courses(Arrays.asList("A", "B", "C", "E"))
        .userListSize(0)
        .testCaseName("Adding invalid user with name empty")
        .build();

    return Stream.of(testCase1, testCase2);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForAddUser")
  void testAddUser(AddUserTestScenario testCase) {

    String name = testCase.getName();
    String address = testCase.getAddress();
    int age = testCase.getAge();
    List<String> courses = testCase.getCourses();
    String rollNo = testCase.getRollNo();
    int expectedSize = testCase.getUserListSize();
    try {
      addUser(name, age, address, rollNo, courses);
      int actualSize = UserCollection.getInstance().getUserList().size();
      assertEquals(expectedSize, actualSize, testCase.getTestCaseName());
    } catch (Exception e) {
      int actualSize = UserCollection.getInstance().getUserList().size();
      assertEquals(expectedSize, actualSize, testCase.getTestCaseName());
    }
  }

  private static Stream<DeleteUserTestScenario> generateTestCaseForDeleteUser() {

    User user = User.builder()
        .name("User 1")
        .age(10)
        .address("address 1 is a long address")
        .rollNo("192")
        .courses(Arrays.asList(CourseType.A, CourseType.B, CourseType.C, CourseType.D))
        .build();
    //Test Case 1 providing valid student roll no
    DeleteUserTestScenario testCase1 = DeleteUserTestScenario.builder()
        .user(user)
        .userListSize(0)
        .rollNoToDelete("192")
        .testCaseName("Deleting valid roll no")
        .build();

    //Test Case 2 providing invalid student roll no
    DeleteUserTestScenario testCase2 = DeleteUserTestScenario.builder()
        .user(user)
        .userListSize(1)
        .rollNoToDelete("194")
        .testCaseName("Deleting invalid roll no")
        .build();

    return Stream.of(testCase1, testCase2);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForDeleteUser")
  void testDeleteUser(DeleteUserTestScenario testCase) {

    User user = testCase.getUser();
    String rollNoToDelete = testCase.getRollNoToDelete();
    int expectedSize = testCase.getUserListSize();
    UserCollection.getInstance().addUser(user);
    try {
      deleteUser(rollNoToDelete);
      int actualSize = UserCollection.getInstance().getUserList().size();
      assertEquals(expectedSize, actualSize, testCase.getTestCaseName());
    } catch (Exception e) {
      int actualSize = UserCollection.getInstance().getUserList().size();
      assertEquals(expectedSize, actualSize, testCase.getTestCaseName());
    }
  }

  private static Stream<GetUserListSortedByOrderTestScenario> generateTestCaseForGetUserListSortedByOrder() {

    User firstUser = User.builder()
        .name("User 1")
        .age(10)
        .address("address 1 is a long address")
        .rollNo("Roll No 1")
        .courses(Arrays.asList(CourseType.A, CourseType.B, CourseType.C, CourseType.D))
        .build();

    User secondUser = User.builder()
        .name("User 2")
        .age(18)
        .address("address 1 is a long address")
        .rollNo("Roll No 2")
        .courses(Arrays.asList(CourseType.A, CourseType.B, CourseType.C, CourseType.D))
        .build();

    User thirdUser = User.builder()
        .name("User 3")
        .age(17)
        .address("address 1 is a long address")
        .rollNo("Roll No 3")
        .courses(Arrays.asList(CourseType.A, CourseType.B, CourseType.C, CourseType.D))
        .build();

    //Test Case
    GetUserListSortedByOrderTestScenario testCase = GetUserListSortedByOrderTestScenario.builder()
        .randomUserList(Arrays.asList(thirdUser, firstUser, secondUser))
        .sortedUserList(Arrays.asList(secondUser, thirdUser, firstUser))
        .order(SortOrderType.AGE_DESC)
        .testCaseName("Sorting by age in descending order")
        .build();

    return Stream.of(testCase);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForGetUserListSortedByOrder")
  void testGetUserListSortedByOrder(GetUserListSortedByOrderTestScenario testCase) {

    UserCollection userCollection = UserCollection.getInstance();
    for (User user : testCase.getRandomUserList()) {
      userCollection.addUser(user);
    }
    SortOrderType order = testCase.getOrder();
    List<User> actual = getUserListSortedByOrder(order);
    List<User> expected = testCase.getSortedUserList();
    assertEquals(expected, actual, testCase.getTestCaseName());
  }

  @AfterEach
  void cleanup() {
    //Clearing user collection
    UserCollection.getInstance().clearUserList();
  }

}