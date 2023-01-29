package studentdirectory.validation.uservalidatortestscenario;

import lombok.Getter;
import lombok.Setter;
import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
@Setter
public class ValidateUserTestScenario extends GenericTestScenario {
  private User user;
}
