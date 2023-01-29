package studentdirectory.validation.uservalidatortestscenario;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
@Setter
public class ValidateCoursesTestScenario extends GenericTestScenario {
  private List<String> courses;

  @Builder
  public ValidateCoursesTestScenario(String errMessage, String testCaseName, List<String> courses) {

    super(errMessage, testCaseName);
    this.courses = courses;
  }

}
