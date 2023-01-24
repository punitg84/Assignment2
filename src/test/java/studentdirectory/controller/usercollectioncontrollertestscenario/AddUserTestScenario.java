package studentdirectory.controller.usercollectioncontrollertestscenario;

import java.util.List;
import studentdirectory.testscenario.GenericTestScenario;

public class AddUserTestScenario extends GenericTestScenario {
  private String name;
  public String age;
  private String address;
  private String rollNo;
  private List<String> courses;
  private int userListSize;

  public int getUserListSize() {
    return userListSize;
  }

  public void setUserListSize(int userListSize) {
    this.userListSize = userListSize;
  }

  public String getName() {
    return name;
  }

  public String getAge() {
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

  public AddUserTestScenario(String name, String age, String address, String rollNo, List<String> courses){
    super();
    this.name=name;
    this.age=age;
    this.address=address;
    this.rollNo=rollNo;
    this.courses=courses;
  }
}
