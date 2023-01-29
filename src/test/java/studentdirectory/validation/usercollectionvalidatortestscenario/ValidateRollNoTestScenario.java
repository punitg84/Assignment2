package studentdirectory.validation.usercollectionvalidatortestscenario;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
@Setter
public class ValidateRollNoTestScenario extends GenericTestScenario {
  private List<User> userList = new ArrayList<>();
  private String rollNo;

  @Builder
  public ValidateRollNoTestScenario(String errMessage,
                                    String testCaseName,
                                    List<User> userList,
                                    String rollNo) {

    super(errMessage, testCaseName);
    this.userList = userList;
    this.rollNo = rollNo;
  }

}
