package studentdirectory.validation.usercollectionvalidatortestcasestructure;

import java.util.ArrayList;
import java.util.List;
import studentdirectory.models.User;
import studentdirectory.testcasestructure.GenericTestCaseStructure;

public class ValidateRollNoTestCaseStructure extends GenericTestCaseStructure {
  private List<User> userList = new ArrayList<>();
  private User newUser;

  public void addUserInUserList(User user) {
    userList.add(user);
  }

  public void setNewUser(User newUser) {
    this.newUser = newUser;
  }

  public List<User> getUserList() {
    return userList;
  }

  public User getNewUser() {
    return newUser;
  }
}
