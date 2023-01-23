package studentdirectory.controller;

import static org.junit.jupiter.api.Assertions.*;
import static studentdirectory.controller.UserCollectionController.addUser;
import static studentdirectory.controller.UserCollectionController.deleteUser;
import static studentdirectory.controller.UserCollectionController.getUserListSortedByOrder;
import static studentdirectory.controller.UserController.createUser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.controller.usercollectioncontrollertestcasestructure.AddUserTestCaseStructure;
import studentdirectory.controller.usercollectioncontrollertestcasestructure.DeleteUserTestCaseStructure;
import studentdirectory.controller.usercollectioncontrollertestcasestructure.GetUserListSortedByOrderTestCaseStructure;
import studentdirectory.controller.usercontrollertestcasestructure.CreateUserTestCaseStructure;
import studentdirectory.enums.Courses;
import studentdirectory.models.User;
import studentdirectory.models.UserCollection;

class UserCollectionControllerTest {

  private static Stream<AddUserTestCaseStructure> generateTestCaseForAddUser() {
    //Test Case 1 providing valid student
    AddUserTestCaseStructure testCase1 =
        new AddUserTestCaseStructure("User 1", "10", "Address 1", "192",
            Arrays.asList("A", "B", "C", "E"));
    testCase1.setUserListSize(1);
    testCase1.setTestCaseName("Adding valid user");

    //Test Case 2 providing invalid student
    AddUserTestCaseStructure testCase2 =
        new AddUserTestCaseStructure("", "10", "Address 2", "193",
            Arrays.asList("A", "B", "C", "E"));
    testCase2.setUserListSize(0);
    testCase2.setTestCaseName("Adding invalid user with name empty");

    return Stream.of(testCase1, testCase2);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForAddUser")
  void testAddUser(AddUserTestCaseStructure testCase) {
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

  private static Stream<DeleteUserTestCaseStructure> generateTestCaseForDeleteUser() {
    //Test Case 1 providing valid student roll no
    DeleteUserTestCaseStructure testCase1 =
        new DeleteUserTestCaseStructure();
    User user1 = new User("User 1", 10, "Address 1", "192",
        Arrays.asList(Courses.A,Courses.B,Courses.C,Courses.D));
    testCase1.setUserListSize(0);
    testCase1.setUser(user1);
    testCase1.setRollNoToDelete("192");
    testCase1.setTestCaseName("Deleting valid roll no");

    //Test Case 2 providing invalid student roll no
    DeleteUserTestCaseStructure testCase2 =
        new DeleteUserTestCaseStructure();
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
  void testDeleteUser(DeleteUserTestCaseStructure testCase) {
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
  private static Stream<GetUserListSortedByOrderTestCaseStructure> generateTestCaseForGetUserListSortedByOrder(){
    //Test Case
    User firstUser = new User("User 1",10,"address 2","Roll No 1", Arrays.asList(Courses.A,Courses.B,Courses.C,Courses.D));
    User secondUser = new User("User 2",18,"address 2","Roll No 3", Arrays.asList(Courses.A,Courses.B,Courses.F,Courses.D));
    User thirdUser = new User("User 3",17,"address 2","Roll No 3", Arrays.asList(Courses.A,Courses.B,Courses.F,Courses.D));
    GetUserListSortedByOrderTestCaseStructure testCase = new GetUserListSortedByOrderTestCaseStructure();
    //Random ordering
    testCase.addUserInRandomUserList(thirdUser);
    testCase.addUserInRandomUserList(firstUser);
    testCase.addUserInRandomUserList(secondUser);
    //Sorted ordering
    testCase.addUserInSortedUserList(secondUser);
    testCase.addUserInSortedUserList(thirdUser);
    testCase.addUserInSortedUserList(firstUser);

    testCase.setAscending(false);
    testCase.setOrder("AGE");
    testCase.setTestCaseName("Sorting by age in descending order");

    return Stream.of(testCase);
  }
  @ParameterizedTest
  @MethodSource("generateTestCaseForGetUserListSortedByOrder")
  void testGetUserListSortedByOrder(GetUserListSortedByOrderTestCaseStructure testCase) {
    UserCollection userCollection = UserCollection.getInstance();
    for(User user:testCase.getRandomUserList()){
      userCollection.addUser(user);
    }
    String order = testCase.getOrder();
    boolean isAscending = testCase.isAscending();
    List<User> actual = getUserListSortedByOrder(order,isAscending);
    List<User> expected = testCase.getSortedUserList();
    assertEquals(expected,actual,testCase.getTestCaseName());
  }

  @AfterEach
  void cleanup(){
    //Clearing user collection
    UserCollection.getInstance().clearUserList();
  }
}