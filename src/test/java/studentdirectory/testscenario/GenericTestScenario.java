package studentdirectory.testscenario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GenericTestScenario {
  private String errMessage;
  private String testCaseName;

  public GenericTestScenario() {
    errMessage = "";
    testCaseName = "";
  }

}
