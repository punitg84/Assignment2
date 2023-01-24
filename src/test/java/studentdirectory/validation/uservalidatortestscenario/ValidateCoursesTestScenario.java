package studentdirectory.validation.uservalidatortestscenario;

import java.util.List;
import studentdirectory.testscenario.GenericTestScenario;

public class ValidateCoursesTestScenario extends GenericTestScenario {
  private List<String> courses;

  public List<String> getCourses() {
    return courses;
  }

  public void setCourses(List<String> courses) {
    this.courses = courses;
  }
}
