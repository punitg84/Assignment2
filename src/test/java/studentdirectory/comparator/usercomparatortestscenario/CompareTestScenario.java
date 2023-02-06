package studentdirectory.comparator.usercomparatortestscenario;

import lombok.Builder;
import lombok.Getter;
import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
public class CompareTestScenario extends GenericTestScenario {

  private User firstUser;
  private User secondUser;
  private int output;

  @Builder
  public CompareTestScenario(String testCaseName,
                             String errMessage,
                             User firstUser,
                             User secondUser,
                             int output) {

    super(testCaseName, errMessage);
    this.firstUser = firstUser;
    this.secondUser = secondUser;
    this.output = output;
  }

}
