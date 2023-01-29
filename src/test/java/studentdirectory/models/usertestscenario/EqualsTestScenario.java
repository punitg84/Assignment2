package studentdirectory.models.usertestscenario;

import lombok.Getter;
import lombok.Setter;
import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
@Setter
public class EqualsTestScenario extends GenericTestScenario {
  private User firstUser;
  private User secondUser;
  private boolean output;

}
