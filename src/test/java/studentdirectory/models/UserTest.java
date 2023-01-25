package studentdirectory.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.enums.Courses;
import studentdirectory.models.usertestscenario.CompareToTestScenario;
import studentdirectory.models.usertestscenario.EqualsTestScenario;
import studentdirectory.models.usertestscenario.HashCodeTestScenario;

class UserTest {

  private static Stream<HashCodeTestScenario> generateTestCaseForHashCode() {
    //Test Case 1 Alpha Numeric Roll No
    User user1 = new User("User 1", 10, "address 1", "Roll No 1",
        Arrays.asList(Courses.A, Courses.B, Courses.C, Courses.D));
    HashCodeTestScenario testCase1 = new HashCodeTestScenario();
    testCase1.setUser(user1);
    testCase1.setOutput(-1813876907);
    testCase1.setTestCaseName("Alpha Numeric Roll No");

    //Test Case 2 Numeric Roll No
    User user2 = new User("User 2", 10, "address 2", "8930",
        Arrays.asList(Courses.A, Courses.B, Courses.C, Courses.D));
    HashCodeTestScenario testCase2 = new HashCodeTestScenario();
    testCase2.setUser(user2);
    testCase2.setOutput(1724702);
    testCase2.setTestCaseName("Numeric Roll No");

    return Stream.of(testCase1, testCase2);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForHashCode")
  void testHashCode(HashCodeTestScenario testCase) {
    User user = testCase.getUser();
    int actualOutput = user.hashCode();
    assertEquals(testCase.getOutput(), actualOutput, testCase.getTestCaseName());
  }

  private static Stream<EqualsTestScenario> generateTestCaseForEquals() {
    //Test Case 1 Same roll no
    User firstUser1 = new User("User 1", 10, "address 1", "Roll No 1",
        Arrays.asList(Courses.A, Courses.B, Courses.C, Courses.D));
    User secondUser1 = new User("User 2", 18, "address 1", "Roll No 1",
        Arrays.asList(Courses.A, Courses.B, Courses.C, Courses.D));
    EqualsTestScenario testCase1 = new EqualsTestScenario();
    testCase1.setFirstUser(firstUser1);
    testCase1.setSecondUser(secondUser1);
    testCase1.setOutput(true);
    testCase1.setTestCaseName("Users have same roll no");

    //Test Case 2 Diff roll no
    User firstUser2 = new User("User 1", 10, "address 1", "Roll No 1",
        Arrays.asList(Courses.A, Courses.B, Courses.C, Courses.D));
    User secondUser2 = new User("User 2", 18, "address 1", "Roll No 3",
        Arrays.asList(Courses.A, Courses.B, Courses.C, Courses.D));
    EqualsTestScenario testCase2 = new EqualsTestScenario();
    testCase2.setFirstUser(firstUser2);
    testCase2.setSecondUser(secondUser2);
    testCase2.setOutput(false);
    testCase2.setTestCaseName("Users have diff roll no");

    return Stream.of(testCase1, testCase2);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForEquals")
  void testEquals(EqualsTestScenario testCase) {
    User firstUser = testCase.getFirstUser();
    User secondUser = testCase.getSecondUser();
    boolean actualOutput = firstUser.equals(secondUser);
    assertEquals(testCase.getOutput(), actualOutput, testCase.getTestCaseName());
  }

  private static Stream<CompareToTestScenario> generateTestForCompareTo() {
    //Test Case 1 Same roll no Diff user name
    User firstUser1 = new User("User 1", 10, "address 1", "Roll No 1",
        Arrays.asList(Courses.A, Courses.B, Courses.C, Courses.D));
    User secondUser1 = new User("User 2", 18, "address 1", "Roll No 1",
        Arrays.asList(Courses.A, Courses.B, Courses.F, Courses.D));
    CompareToTestScenario testCase1 = new CompareToTestScenario();
    testCase1.setFirstUser(firstUser1);
    testCase1.setSecondUser(secondUser1);
    testCase1.setOutput(-1);
    testCase1.setTestCaseName("Users have same roll no diff user name");

    //Test Case 2 Diff roll no Same user name
    User firstUser2 = new User("User 1", 10, "address 1", "Roll No 3",
        Arrays.asList(Courses.A, Courses.B, Courses.C, Courses.D));
    User secondUser2 = new User("User 1", 18, "address 1", "Roll No 1",
        Arrays.asList(Courses.A, Courses.B, Courses.F, Courses.D));
    CompareToTestScenario testCase2 = new CompareToTestScenario();
    testCase2.setFirstUser(firstUser2);
    testCase2.setSecondUser(secondUser2);
    testCase2.setOutput(1);
    testCase2.setTestCaseName("Users have diff roll no same user name");

    return Stream.of(testCase1, testCase2);
  }

  @ParameterizedTest
  @MethodSource("generateTestForCompareTo")
  void testCompareTo(CompareToTestScenario testCase) {
    User firstUser = testCase.getFirstUser();
    User secondUser = testCase.getSecondUser();
    int actualOutput = firstUser.compareTo(secondUser);
    int expectedOutput = testCase.getOutput();
    assertEquals(Math.signum(expectedOutput), Math.signum(actualOutput),
        testCase.getTestCaseName());
  }
}