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
import studentdirectory.enums.Courses;
import studentdirectory.enums.SortOrder;
import studentdirectory.models.User;
import studentdirectory.models.UserCollection;

class UserCollectionControllerTest {

  private static Stream<AddUserTestScenario> generateTestCaseForAddUser() {
    //Test Case 1 providing valid student
    AddUserTestScenario testCase1 =
        new AddUserTestScenario("User 1", "10", "Address 1 is a long value", "192",
            Arrays.asList("A", "B", "C", "E"));
    testCase1.setUserListSize(1);
    testCase1.setTestCaseName("Adding valid user");

    //Test Case 2 providing invalid student
    AddUserTestScenario testCase2 =
        new AddUserTestScenario("", "10", "Address 2", "193",
            Arrays.asList("A", "B", "C", "E"));
    testCase2.setUserListSize(0);
    testCase2.setTestCaseName("Adding invalid user with name empty");

    return Stream.of(testCase1, testCase2);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForAddUser")
  void testAddUser(AddUserTestScenario testCase) {
    String name = testCase.getName();
    String address = testCase.getAddress();
    String age = testCase.getAge();
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
    //Test Case 1 providing valid student roll no
    DeleteUserTestScenario testCase1 =
        new DeleteUserTestScenario();
    User user1 = new User("User 1", 10, "Address 1", "192",
        Arrays.asList(Courses.A,Courses.B,Courses.C,Courses.D));
    testCase1.setUserListSize(0);
    testCase1.setUser(user1);
    testCase1.setRollNoToDelete("192");
    testCase1.setTestCaseName("Deleting valid roll no");

    //Test Case 2 providing invalid student roll no
    DeleteUserTestScenario testCase2 =
        new DeleteUserTestScenario();
    User user2 = new User("User 2", 10, "Address 2", "192",
        Arrays.asList(Courses.A,Courses.B,Courses.C,Courses.D));
    testCase2.setUserListSize(1);
    testCase2.setUser(user2);
    testCase2.setRollNoToDelete("194");
    testCase2.setTestCaseName("Deleting invalid roll no");

    return Stream.of(testCase1,testCase2);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForDeleteUser")
  void testDeleteUser(DeleteUserTestScenario testCase) {
    User user = testCase.getUser();
    String rollNoToDelete = testCase.getRollNoToDelete();
    int expectedSize = testCase.getUserListSize();
    UserCollection.getInstance().addUser(user);
    try{
      deleteUser(rollNoToDelete);
      int actualSize = UserCollection.getInstance().getUserList().size();
      assertEquals(expectedSize, actualSize, testCase.getTestCaseName());
    }catch(Exception e){
      int actualSize = UserCollection.getInstance().getUserList().size();
      assertEquals(expectedSize, actualSize, testCase.getTestCaseName());
    }
  }
  private static Stream<GetUserListSortedByOrderTestScenario> generateTestCaseForGetUserListSortedByOrder(){
    //Test Case
    User firstUser = new User("User 1",10,"address 2","Roll No 1", Arrays.asList(Courses.A,Courses.B,Courses.C,Courses.D));
    User secondUser = new User("User 2",18,"address 2","Roll No 3", Arrays.asList(Courses.A,Courses.B,Courses.F,Courses.D));
    User thirdUser = new User("User 3",17,"address 2","Roll No 3", Arrays.asList(Courses.A,Courses.B,Courses.F,Courses.D));
    GetUserListSortedByOrderTestScenario testCase = new GetUserListSortedByOrderTestScenario();
    //Random ordering
    testCase.addUserInRandomUserList(thirdUser);
    testCase.addUserInRandomUserList(firstUser);
    testCase.addUserInRandomUserList(secondUser);
    //Sorted ordering
    testCase.addUserInSortedUserList(secondUser);
    testCase.addUserInSortedUserList(thirdUser);
    testCase.addUserInSortedUserList(firstUser);

    testCase.setOrder(SortOrder.AGE_DESC);
    testCase.setTestCaseName("Sorting by age in descending order");

    return Stream.of(testCase);
  }
  @ParameterizedTest
  @MethodSource("generateTestCaseForGetUserListSortedByOrder")
  void testGetUserListSortedByOrder(GetUserListSortedByOrderTestScenario testCase) {
    UserCollection userCollection = UserCollection.getInstance();
    for(User user:testCase.getRandomUserList()){
      userCollection.addUser(user);
    }
    SortOrder order = testCase.getOrder();
    List<User> actual = getUserListSortedByOrder(order);
    List<User> expected = testCase.getSortedUserList();
    assertEquals(expected,actual,testCase.getTestCaseName());
  }

  @AfterEach
  void cleanup(){
    //Clearing user collection
    UserCollection.getInstance().clearUserList();
  }
}