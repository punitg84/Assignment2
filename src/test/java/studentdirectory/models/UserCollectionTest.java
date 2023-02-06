package studentdirectory.models;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import studentdirectory.models.usercollectiontestscenario.LoadDataTestScenario;
import studentdirectory.utils.FileUtility;

@ExtendWith(MockitoExtension.class)
class UserCollectionTest {

  @Mock
  FileUtility utility;

  private static Stream<LoadDataTestScenario> generateTestCaseForLoadData() throws Exception{
    List<Course> courses = new ArrayList<>();
    for(String type:Arrays.asList("A","B","C","D")){
      courses.add(new Course(type));
    }

    return Stream.of(
        LoadDataTestScenario.builder()
            .users(Arrays.asList(
                User.builder()
                    .name("Punit Gurnani")
                    .age(10)
                    .rollNo("19")
                    .address("Address 1 containing less than 100 char")
                    .courses(courses)
                    .build()
            ))
            .testCaseName("Loading data")
            .errMessage("")
            .build()
    );
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForLoadData")
  void loadData(LoadDataTestScenario testCase) throws Exception {
    String testCaseName = testCase.getTestCaseName();
    List<User> users = testCase.getUsers();

    when(utility.readObjectFromFile()).thenReturn(users);

    UserCollection userCollection = UserCollection.getInstance();
    userCollection.setFileUtility(utility);
    userCollection.loadData();

    assertEquals(users.size(),userCollection.getUserList().size(),testCaseName);
  }
}