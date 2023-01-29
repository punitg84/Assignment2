package studentdirectory.validation.uservalidatortestscenario;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
@Setter
public class ValidateCoursesTestScenario extends GenericTestScenario {
  private List<String> courses;

}
