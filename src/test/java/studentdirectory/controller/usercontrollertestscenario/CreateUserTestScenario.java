package studentdirectory.controller.usercontrollertestscenario;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
@Setter
public class CreateUserTestScenario extends GenericTestScenario {
  private String name;
  private int age;
  private String address;
  private String rollNo;
  private List<String> courses;

  @Builder
  public CreateUserTestScenario(String errMessage,
                                String testCaseName,
                                String name,
                                int age,
                                String address,
                                String rollNo,
                                List<String> courses) {

    super(errMessage, testCaseName);
    this.name = name;
    this.age = age;
    this.address = address;
    this.rollNo = rollNo;
    this.courses = courses;
  }

}
