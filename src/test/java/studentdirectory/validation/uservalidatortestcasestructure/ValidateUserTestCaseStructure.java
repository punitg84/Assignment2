package studentdirectory.validation.uservalidatortestcasestructure;

import studentdirectory.models.User;
import studentdirectory.testcasestructure.GenericTestCaseStructure;

public class ValidateUserTestCaseStructure extends GenericTestCaseStructure {
  private User user;

  public void setUser(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }
}
