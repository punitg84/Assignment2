package studentdirectory.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.enums.CourseType;
import studentdirectory.models.usertestscenario.CompareToTestScenario;

class UserTest {

  private static Stream<CompareToTestScenario> generateTestForCompareTo() {
    User user1 = User.builder()
                    .name("User 1")
                    .age(10)
                    .address("address 1")
                    .rollNo("Roll No 1")
                    .courses(Arrays.asList(CourseType.A, CourseType.B, CourseType.C, CourseType.D))
                    .build();

    User user2 = User.builder()
                      .name("User 2")
                      .age(10)
                      .address("address 1")
                      .rollNo("Roll No 1")
                      .courses(Arrays.asList(CourseType.A, CourseType.B, CourseType.C, CourseType.D))
                      .build();

    User user3 = User.builder()
                    .name("User 1")
                    .age(10)
                    .address("address 1")
                    .rollNo("Roll No 2")
                    .courses(Arrays.asList(CourseType.A, CourseType.B, CourseType.C, CourseType.D))
                    .build();

    //Test Case 1 Same roll no Diff user name
    CompareToTestScenario testCase1 = CompareToTestScenario.builder()
                                      .firstUser(user1)
                                      .secondUser(user2)
                                      .output(-1)
                                      .testCaseName("Users have same roll no diff user name")
                                      .build();

    //Test Case 2 Diff roll no Same user name
    CompareToTestScenario testCase2 = CompareToTestScenario.builder()
        .firstUser(user3)
        .secondUser(user1)
        .output(1)
        .testCaseName("Users have diff roll no same user name")
        .build();

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