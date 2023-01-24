package studentdirectory.models.usertestscenario;

import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

public class HashCodeTestScenario extends GenericTestScenario {
  private User user;
  private int output;

  public int getOutput() {
    return output;
  }

  public void setOutput(int output) {
    this.output = output;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
