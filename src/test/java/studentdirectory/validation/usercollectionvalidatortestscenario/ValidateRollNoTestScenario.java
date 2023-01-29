package studentdirectory.validation.usercollectionvalidatortestscenario;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
@Setter
public class ValidateRollNoTestScenario extends GenericTestScenario {
  private List<User> userList = new ArrayList<>();
  private String rollNo;

}
