package studentdirectory.models.usertestscenario;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
@Setter
public class CompareToTestScenario extends GenericTestScenario {
  private User firstUser;
  private User secondUser;
  private int output;

  @Builder
  public CompareToTestScenario(String errMessage,
                               String testCaseName,
                               User firstUser,
                               User secondUser,
                               int output) {

    super(errMessage, testCaseName);
    this.firstUser = firstUser;
    this.secondUser = secondUser;
    this.output = output;
  }

}
