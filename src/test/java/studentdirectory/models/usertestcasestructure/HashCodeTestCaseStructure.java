package studentdirectory.models.usertestcasestructure;

import studentdirectory.models.User;
import studentdirectory.testcasestructure.GenericTestCaseStructure;

public class HashCodeTestCaseStructure extends GenericTestCaseStructure {
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
