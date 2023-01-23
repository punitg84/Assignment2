package studentdirectory.validation.uservalidatortestcasestructure;

import java.util.List;
import studentdirectory.testcasestructure.GenericTestCaseStructure;

public class ValidateCoursesTestCaseStructure extends GenericTestCaseStructure {
  private List<String> courses;

  public List<String> getCourses() {
    return courses;
  }

  public void setCourses(List<String> courses) {
    this.courses = courses;
  }
}
