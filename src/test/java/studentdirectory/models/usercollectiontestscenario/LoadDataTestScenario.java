package studentdirectory.models.usercollectiontestscenario;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
public class LoadDataTestScenario extends GenericTestScenario {

  private List<User> users;

  @Builder
  public LoadDataTestScenario(String errMessage, String testCaseName, List<User> users) {
    super(errMessage, testCaseName);
    this.users = users;
  }

}
