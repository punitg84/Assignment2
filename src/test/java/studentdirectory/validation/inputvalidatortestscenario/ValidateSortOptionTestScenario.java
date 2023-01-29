package studentdirectory.validation.inputvalidatortestscenario;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
@Setter
public class ValidateSortOptionTestScenario extends GenericTestScenario {
  String inputString;

  @Builder
  public ValidateSortOptionTestScenario(String errMessage, String testCaseName,
                                        String inputString) {

    super(errMessage, testCaseName);
    this.inputString = inputString;
  }

}
