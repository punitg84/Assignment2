package studentdirectory.comparator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.models.User;
import studentdirectory.models.usertestcasestructure.CompareToTestCaseStructure;

class UserComparatorByAddressAscTest {
  private static Stream<CompareToTestCaseStructure> generateTestForCompare(){
    //Test Case 1 User 1 address less than User 2 address
    User firstUser1 = new User("User 1",10,"address 1","Roll No 1", Arrays.asList("A","B","C","D"));
    User secondUser1 = new User("User 2",18,"address 2","Roll No 1", Arrays.asList("A","B","F","D"));
    CompareToTestCaseStructure testCase1 = new CompareToTestCaseStructure();
    testCase1.setFirstUser(firstUser1);
    testCase1.setSecondUser(secondUser1);
    testCase1.setOutput(1);
    testCase1.setTestCaseName("User 1 address less than User 2 address");

    //Test Case 2 User 2 address less than User 1 address
    User firstUser2 = new User("User 1",10,"address 2","Roll No 1", Arrays.asList("A","B","C","D"));
    User secondUser2 = new User("User 2",18,"address 1","Roll No 3", Arrays.asList("A","B","F","D"));
    CompareToTestCaseStructure testCase2 = new CompareToTestCaseStructure();
    testCase2.setFirstUser(firstUser2);
    testCase2.setSecondUser(secondUser2);
    testCase2.setOutput(-1);
    testCase2.setTestCaseName("User 2 address less than User 1 address");

    //Test Case 3 Same address
    User firstUser3 = new User("User 1",10,"address 2","Roll No 1", Arrays.asList("A","B","C","D"));
    User secondUser3 = new User("User 2",18,"address 2","Roll No 3", Arrays.asList("A","B","F","D"));
    CompareToTestCaseStructure testCase3 = new CompareToTestCaseStructure();
    testCase3.setFirstUser(firstUser3);
    testCase3.setSecondUser(secondUser3);
    testCase3.setOutput(0);
    testCase3.setTestCaseName("User have same address");
    return Stream.of(testCase1,testCase3);
  }

  @ParameterizedTest
  @MethodSource("generateTestForCompare")
  void compare(CompareToTestCaseStructure testCase) {
    UserComparatorByAddressAsc comparator = new UserComparatorByAddressAsc();
    User firstUser = testCase.getFirstUser();
    User secondUser = testCase.getSecondUser();
    int actualOutput = comparator.compare(firstUser,secondUser);
    assertEquals(testCase.getOutput(),actualOutput,testCase.getTestCaseName());
  }
}