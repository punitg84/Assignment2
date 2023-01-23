package studentdirectory.models.usertestcasestructure;

import studentdirectory.models.User;
import studentdirectory.testcasestructure.GenericTestCaseStructure;

public class CompareToTestCaseStructure extends GenericTestCaseStructure {
  private User firstUser;
  private User secondUser;
  private int output;

  public int getOutput() {
    return output;
  }

  public void setOutput(int output) {
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
