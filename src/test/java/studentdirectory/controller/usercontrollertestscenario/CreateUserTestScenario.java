package studentdirectory.controller.usercontrollertestscenario;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserTestScenario extends GenericTestScenario {
  private String name;
  public int age;
  private String address;
  private String rollNo;
  private List<String> courses;

}
