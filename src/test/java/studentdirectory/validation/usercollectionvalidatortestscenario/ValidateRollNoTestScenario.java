package studentdirectory.validation.usercollectionvalidatortestscenario;

import java.util.ArrayList;
import java.util.List;
import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

public class ValidateRollNoTestScenario extends GenericTestScenario {
  private List<User> userList = new ArrayList<>();
  private String rollNo;

  public String getRollNo() {
    return rollNo;
  }

  public void setRollNo(String rollNo) {
    this.rollNo = rollNo;
  }

  public void addUserInUserList(User user) {
    userList.add(user);
  }

  public List<User> getUserList() {
    return userList;
  }
}
