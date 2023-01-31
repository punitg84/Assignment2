package studentdirectory.comparator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.comparator.usercomparatortestscenario.CompareTestScenario;
import studentdirectory.enums.CourseType;
import studentdirectory.models.Course;
import studentdirectory.models.User;
import studentdirectory.models.usertestscenario.CompareToTestScenario;

class UserComparatorByAgeDescTest {

  private static Stream<CompareTestScenario> generateTestForCompare() throws Exception {
    List<Course> courses = new ArrayList<>();
    for(String type:Arrays.asList("A","B","C","D")){
      courses.add(new Course(type));
    }

    User user1 = User.builder()
        .name("User 1")
        .age(10)
        .address("address 1")
        .rollNo("Roll No 1")
        .courses(courses)
        .build();
    User user2 = User.builder()
        .name("User 2")
        .age(18)
        .address("address 2")
        .rollNo("Roll No 2")
        .courses(courses)
        .build();

    //Test Case 1 User 1 age less than User 2 age
    CompareTestScenario testCase1 = CompareTestScenario.builder()
        .firstUser(user1)
        .secondUser(user2)
        .output(1)
        .testCaseName("second user less")
        .errMessage("")
        .build();

    //Test Case 2 User 2 age less than User 1 age
    CompareTestScenario testCase2 = CompareTestScenario.builder()
        .firstUser(user2)
        .secondUser(user1)
        .output(-1)
        .testCaseName("first user less")
        .errMessage("")
        .build();

    //Test Case 3 Same age
    CompareTestScenario testCase3 = CompareTestScenario.builder()
        .firstUser(user1)
        .secondUser(user1)
        .output(0)
        .testCaseName("Equal")
        .errMessage("")
        .build();

    return Stream.of(testCase1, testCase2, testCase3);
  }

  @ParameterizedTest
  @MethodSource("generateTestForCompare")
  void compare(CompareTestScenario testCase) {

    UserComparatorByAgeDesc comparator = new UserComparatorByAgeDesc();
    User firstUser = testCase.getFirstUser();
    User secondUser = testCase.getSecondUser();
    int actualOutput = comparator.compare(firstUser, secondUser);
    assertEquals(testCase.getOutput(), actualOutput, testCase.getTestCaseName());
  }

}