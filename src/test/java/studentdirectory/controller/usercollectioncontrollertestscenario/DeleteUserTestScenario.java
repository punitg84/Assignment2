package studentdirectory.controller.usercollectioncontrollertestscenario;

import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

public class DeleteUserTestScenario extends GenericTestScenario {
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
