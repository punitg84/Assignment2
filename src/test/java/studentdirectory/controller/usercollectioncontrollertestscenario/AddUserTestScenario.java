package studentdirectory.controller.usercollectioncontrollertestscenario;

import java.util.List;
import lombok.Builder;
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

  @Builder
  public AddUserTestScenario(String errMessage, String testCaseName, String name, int age,
                             String address, String rollNo, List<String> courses,
                             int userListSize) {

    super(errMessage, testCaseName);
    this.name = name;
    this.age = age;
    this.address = address;
    this.rollNo = rollNo;
    this.courses = courses;
    this.userListSize = userListSize;
  }

}
