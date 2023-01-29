package studentdirectory.controller.usercollectioncontrollertestscenario;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
@Setter
public class AddUserTestScenario extends GenericTestScenario {
  private String name;
  public int age;
  private String address;
  private String rollNo;
  private List<String> courses;
  private int userListSize;

  public AddUserTestScenario(String name, int age, String address, String rollNo,
                             List<String> courses) {
    super();
    this.name = name;
    this.age = age;
    this.address = address;
    this.rollNo = rollNo;
    this.courses = courses;
  }
}
