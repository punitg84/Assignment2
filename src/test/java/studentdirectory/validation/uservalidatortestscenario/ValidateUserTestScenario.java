package studentdirectory.validation.uservalidatortestscenario;

import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

public class ValidateUserTestScenario extends GenericTestScenario {
  private User user;

  public void setUser(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }
}
