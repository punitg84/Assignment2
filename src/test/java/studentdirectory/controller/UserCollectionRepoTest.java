package studentdirectory.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.controller.usercollectioncontrollertestscenario.AddUserTestScenario;
import studentdirectory.controller.usercollectioncontrollertestscenario.DeleteUserTestScenario;
import studentdirectory.controller.usercollectioncontrollertestscenario.GetUserListSortedByOrderTestScenario;
import studentdirectory.enums.SortOrderType;
import studentdirectory.models.Course;
import studentdirectory.models.User;
import studentdirectory.models.UserCollection;

class UserCollectionRepoTest {

  private static Stream<AddUserTestScenario> generateTestCaseForAddUser() throws Exception {
    List<Course> courses = new ArrayList<>();
    for(String type:Arrays.asList("A","B","C","D")){
      courses.add(new Course(type));
    }

    User user1 = User.builder()
        .name("User 1")
        .age(10)
        .address("address 1 is a really long value")
        .rollNo("Roll No 1")
        .courses(courses)
        .build();

    //Test Case 1 providing valid student
    AddUserTestScenario testCase1 = AddUserTestScenario.builder()
        .user(user1)
        .userListSize(1)
        .testCaseName("Adding valid user")
        .build();

    return Stream.of(testCase1);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForAddUser")
  void testAddUser(AddUserTestScenario testCase) throws Exception {
    User user = testCase.getUser();
    int expectedSize = testCase.getUserListSize();
    try {
      UserCollectionRepo userCollectionRepo = new UserCollectionRepo(UserCollection.getInstance());
      userCollectionRepo.addUser(user);
      int actualSize = UserCollection.getInstance().getUserList().size();
      assertEquals(expectedSize, actualSize, testCase.getTestCaseName());
    } catch (Exception e) {
      int actualSize = UserCollection.getInstance().getUserList().size();
      assertEquals(expectedSize, actualSize, testCase.getTestCaseName());
    }
  }

  private static Stream<DeleteUserTestScenario> generateTestCaseForDeleteUser() throws Exception {

    List<Course> courses = new ArrayList<>();
    for(String type:Arrays.asList("A","B","C","D")){
      courses.add(new Course(type));
    }

    User user = User.builder()
        .name("User 1")
        .age(10)
        .address("address 1 is a really long value")
        .rollNo("192")
        .courses(courses)
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
  void testDeleteUser(DeleteUserTestScenario testCase) throws Exception {
    UserCollectionRepo userCollectionRepo = new UserCollectionRepo(UserCollection.getInstance());
    User user = testCase.getUser();
    String rollNoToDelete = testCase.getRollNoToDelete();
    int expectedSize = testCase.getUserListSize();
    UserCollection.getInstance().addUser(user);
    try {
      userCollectionRepo.deleteUser(rollNoToDelete);
      int actualSize = UserCollection.getInstance().getUserList().size();
      assertEquals(expectedSize, actualSize, testCase.getTestCaseName());
    } catch (Exception e) {
      int actualSize = UserCollection.getInstance().getUserList().size();
      assertEquals(expectedSize, actualSize, testCase.getTestCaseName());
    }
  }

  private static Stream<GetUserListSortedByOrderTestScenario> generateTestCaseForGetUserListSortedByOrder()
      throws Exception {
    List<Course> courses = new ArrayList<>();
    for(String type:Arrays.asList("A","B","C","D")){
      courses.add(new Course(type));
    }

    User firstUser = User.builder()
        .name("User 1")
        .age(10)
        .address("address 1 is a long address")
        .rollNo("Roll No 1")
        .courses(courses)
        .build();

    User secondUser = User.builder()
        .name("User 2")
        .age(18)
        .address("address 1 is a long address")
        .rollNo("Roll No 2")
        .courses(courses)
        .build();

    User thirdUser = User.builder()
        .name("User 3")
        .age(17)
        .address("address 1 is a long address")
        .rollNo("Roll No 3")
        .courses(courses)
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
  void testGetUserListSortedByOrder(GetUserListSortedByOrderTestScenario testCase)
      throws Exception {
    UserCollectionRepo userCollectionRepo = new UserCollectionRepo(UserCollection.getInstance());
    UserCollection userCollection = UserCollection.getInstance();
    for (User user : testCase.getRandomUserList()) {
      userCollection.addUser(user);
    }
    SortOrderType order = testCase.getOrder();
    List<User> actual = userCollectionRepo.getSortedUserList(order);
    List<User> expected = testCase.getSortedUserList();
    assertEquals(expected, actual, testCase.getTestCaseName());
  }

  @AfterEach
  void cleanup() throws Exception {
    //Clearing user collection
    UserCollection.getInstance().clearUserList();
  }

}