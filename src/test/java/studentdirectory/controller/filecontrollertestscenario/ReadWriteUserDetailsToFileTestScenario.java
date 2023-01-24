package studentdirectory.controller.filecontrollertestscenario;

import java.util.ArrayList;
import java.util.List;
import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

public class ReadWriteUserDetailsToFileTestScenario extends GenericTestScenario {
  List<User> userList = new ArrayList<>();

  public List<User> getUserList() {
    return userList;
  }

  public void addUser(User user) {
    userList.add(user);
  }
}
