package studentdirectory.controller.usercontrollertestscenario;

import java.util.List;
import studentdirectory.testscenario.GenericTestScenario;

public class CreateUserTestScenario extends GenericTestScenario {
  private String name;
  public int age;
  private String address;
  private String rollNo;
  private List<String> courses;

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getAddress() {
    return address;
  }

  public String getRollNo() {
    return rollNo;
  }

  public List<String> getCourses() {
    return courses;
  }

  public CreateUserTestScenario(String name, int age, String address, String rollNo,
                                List<String> courses) {
    super();
    this.name = name;
    this.age = age;
    this.address = address;
    this.rollNo = rollNo;
    this.courses = courses;
  }
}
