package studentdirectory.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.enums.Courses;
import studentdirectory.models.usertestcasestructure.CompareToTestCaseStructure;
import studentdirectory.models.usertestcasestructure.EqualsTestCaseStructure;
import studentdirectory.models.usertestcasestructure.HashCodeTestCaseStructure;

class UserTest {

  private static Stream<HashCodeTestCaseStructure> generateTestCaseForHashCode(){
    //Test Case 1 Alpha Numeric Roll No
    User user1 = new User("User 1",10,"address 1","Roll No 1", Arrays.asList(Courses.A,Courses.B,Courses.C,Courses.D));
    HashCodeTestCaseStructure testCase1 = new HashCodeTestCaseStructure();
    testCase1.setUser(user1);
    testCase1.setOutput(100);
    testCase1.setTestCaseName("Alpha Numeric Roll No");

    //Test Case 2 Numeric Roll No
    User user2 = new User("User 2",10,"address 2","8930", Arrays.asList(Courses.A,Courses.B,Courses.C,Courses.D));
    HashCodeTestCaseStructure testCase2 = new HashCodeTestCaseStructure();
    testCase2.setUser(user2);
    testCase2.setOutput(120);
    testCase2.setTestCaseName("Numeric Roll No");

    return Stream.of(testCase1,testCase2);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForHashCode")
  void testHashCode(HashCodeTestCaseStructure testCase) {
    User user = testCase.getUser();
    int actualOutput = user.hashCode();
    assertEquals(testCase.getOutput(),actualOutput,testCase.getTestCaseName());
  }

  private static Stream<EqualsTestCaseStructure> generateTestCaseForEquals(){
    //Test Case 1 Same roll no
    User firstUser1 = new User("User 1",10,"address 1","Roll No 1", Arrays.asList(Courses.A,Courses.B,Courses.C,Courses.D));
    User secondUser1 = new User("User 2",18,"address 1","Roll No 1", Arrays.asList(Courses.A,Courses.B,Courses.C,Courses.D));
    EqualsTestCaseStructure testCase1 = new EqualsTestCaseStructure();
    testCase1.setFirstUser(firstUser1);
    testCase1.setSecondUser(secondUser1);
    testCase1.setOutput(true);
    testCase1.setTestCaseName("Users have same roll no");

    //Test Case 2 Diff roll no
    User firstUser2 = new User("User 1",10,"address 1","Roll No 1", Arrays.asList(Courses.A,Courses.B,Courses.C,Courses.D));
    User secondUser2 = new User("User 2",18,"address 1","Roll No 3", Arrays.asList(Courses.A,Courses.B,Courses.C,Courses.D));
    EqualsTestCaseStructure testCase2 = new EqualsTestCaseStructure();
    testCase2.setFirstUser(firstUser2);
    testCase2.setSecondUser(secondUser2);
    testCase2.setOutput(false);
    testCase2.setTestCaseName("Users have diff roll no");

    return Stream.of(testCase1,testCase2);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForEquals")
  void testEquals(EqualsTestCaseStructure testCase) {
    User firstUser = testCase.getFirstUser();
    User secondUser = testCase.getSecondUser();
    boolean actualOutput = firstUser.equals(secondUser);
    assertEquals(testCase.getOutput(),actualOutput,testCase.getTestCaseName());
  }

  private static Stream<CompareToTestCaseStructure> generateTestForCompareTo(){
    //Test Case 1 Same roll no Diff user name
    User firstUser1 = new User("User 1",10,"address 1","Roll No 1", Arrays.asList(Courses.A,Courses.B,Courses.C,Courses.D));
    User secondUser1 = new User("User 2",18,"address 1","Roll No 1", Arrays.asList(Courses.A,Courses.B,Courses.F,Courses.D));
    CompareToTestCaseStructure testCase1 = new CompareToTestCaseStructure();
    testCase1.setFirstUser(firstUser1);
    testCase1.setSecondUser(secondUser1);
    testCase1.setOutput(1);
    testCase1.setTestCaseName("Users have same roll no diff user name");

    //Test Case 2 Diff roll no Same user name
    User firstUser2 = new User("User 1",10,"address 1","Roll No 1", Arrays.asList(Courses.A,Courses.B,Courses.C,Courses.D));
    User secondUser2 = new User("User 1",18,"address 1","Roll No 3", Arrays.asList(Courses.A,Courses.B,Courses.F,Courses.D));
    CompareToTestCaseStructure testCase2 = new CompareToTestCaseStructure();
    testCase2.setFirstUser(firstUser2);
    testCase2.setSecondUser(secondUser2);
    testCase2.setOutput(0);
    testCase2.setTestCaseName("Users have diff roll no same user name");

    return Stream.of(testCase1,testCase2);
  }
  @ParameterizedTest
  @MethodSource("generateTestForCompareTo")
  void testCompareTo(CompareToTestCaseStructure testCase) {
    User firstUser = testCase.getFirstUser();
    User secondUser = testCase.getSecondUser();
    int actualOutput = firstUser.compareTo(secondUser);
    assertEquals(testCase.getOutput(),actualOutput,testCase.getTestCaseName());
  }
}