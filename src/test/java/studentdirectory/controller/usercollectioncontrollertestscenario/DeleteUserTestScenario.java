package studentdirectory.controller.usercollectioncontrollertestscenario;

import lombok.AllArgsConstructor;
import lombok.Builder;
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

  @Builder
  public DeleteUserTestScenario(String errMessage,
                                String testCaseName,
                                User user,
                                String rollNoToDelete,
                                int userListSize) {

    super(errMessage, testCaseName);
    this.user = user;
    this.rollNoToDelete = rollNoToDelete;
    this.userListSize = userListSize;
  }

}
