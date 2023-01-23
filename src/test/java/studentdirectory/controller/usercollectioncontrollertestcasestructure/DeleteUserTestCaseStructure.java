package studentdirectory.controller.usercollectioncontrollertestcasestructure;

import studentdirectory.models.User;
import studentdirectory.testcasestructure.GenericTestCaseStructure;

public class DeleteUserTestCaseStructure extends GenericTestCaseStructure {
  private User user;
  private String rollNoToDelete;

  private int userListSize;

  public int getUserListSize() {
    return userListSize;
  }

  public void setUserListSize(int userListSize) {
    this.userListSize = userListSize;
  }

  public String getRollNoToDelete() {
    return rollNoToDelete;
  }

  public void setRollNoToDelete(String rollNoToDelete) {
    this.rollNoToDelete = rollNoToDelete;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }
}
