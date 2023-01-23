package studentdirectory.models.usertestcasestructure;

import studentdirectory.models.User;
import studentdirectory.testcasestructure.GenericTestCaseStructure;

public class EqualsTestCaseStructure extends GenericTestCaseStructure {
  private User firstUser;
  private User secondUser;
  private boolean output;

  public boolean getOutput() {
    return output;
  }

  public void setOutput(boolean output) {
    this.output = output;
  }

  public User getFirstUser() {
    return firstUser;
  }

  public void setFirstUser(User firstUser) {
    this.firstUser = firstUser;
  }

  public User getSecondUser() {
    return secondUser;
  }

  public void setSecondUser(User secondUser) {
    this.secondUser = secondUser;
  }
}
