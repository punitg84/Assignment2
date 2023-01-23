package studentdirectory.controller.filecontrollertestcasestructure;

import java.util.ArrayList;
import java.util.List;
import studentdirectory.models.User;
import studentdirectory.testcasestructure.GenericTestCaseStructure;

public class ReadWriteUserDetailsToFileTestCaseStructure extends GenericTestCaseStructure {
  List<User> userList = new ArrayList<>();

  public List<User> getUserList() {
    return userList;
  }

  public void addUser(User user) {
    userList.add(user);
  }
}
