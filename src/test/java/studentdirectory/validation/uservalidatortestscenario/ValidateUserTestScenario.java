package studentdirectory.validation.uservalidatortestscenario;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
@Setter
public class ValidateUserTestScenario extends GenericTestScenario {
  private User user;

  @Builder
  public ValidateUserTestScenario(String errMessage,
                                  String testCaseName,
                                  User user) {

    super(errMessage, testCaseName);
    this.user = user;
  }

}
