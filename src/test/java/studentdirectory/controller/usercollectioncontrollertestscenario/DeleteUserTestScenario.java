package studentdirectory.controller.usercollectioncontrollertestscenario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
@Setter
public class DeleteUserTestScenario extends GenericTestScenario {
  private User user;
  private String rollNoToDelete;
  private int userListSize;
}
