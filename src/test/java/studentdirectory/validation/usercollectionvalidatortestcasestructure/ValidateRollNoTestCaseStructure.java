package studentdirectory.validation.usercollectionvalidatortestcasestructure;

import java.util.ArrayList;
import java.util.List;
import studentdirectory.models.User;
import studentdirectory.testcasestructure.GenericTestCaseStructure;

public class ValidateRollNoTestCaseStructure extends GenericTestCaseStructure {
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
