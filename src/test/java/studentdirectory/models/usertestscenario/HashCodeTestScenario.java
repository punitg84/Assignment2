package studentdirectory.models.usertestscenario;

import lombok.Getter;
import lombok.Setter;
import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
@Setter
public class HashCodeTestScenario extends GenericTestScenario {
  private User user;
  private int output;

}
