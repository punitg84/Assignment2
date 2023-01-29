package studentdirectory.controller.filecontrollertestscenario;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
@Setter
public class ReadWriteToFileTestScenario extends GenericTestScenario {
  List<User> userList;

  @Builder
  public ReadWriteToFileTestScenario(String errMessage, String testCaseName,
                                     List<User> userList) {

    super(errMessage, testCaseName);
    this.userList = userList;
  }

}
