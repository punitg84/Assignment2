package studentdirectory.controller.usercollectioncontrollertestscenario;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
@Setter
public class AddUserTestScenario extends GenericTestScenario {
  private User user;
  private int userListSize;

  @Builder

  public AddUserTestScenario(String errMessage, String testCaseName, User user, int userListSize) {
    super(errMessage, testCaseName);
    this.user = user;
    this.userListSize = userListSize;
  }

}
