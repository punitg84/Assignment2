package studentdirectory.controller.filecontrollertestscenario;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
@Setter
public class ReadWriteUserDetailsToFileTestScenario extends GenericTestScenario {
  List<User> userList = new ArrayList<>();
}
