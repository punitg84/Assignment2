package studentdirectory.models;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable, Comparable<User> {

  private String name;
  public int age;
  private String address;
  private String rollNo;
  private List<String> courses;

  public String getRollNo() {
    return rollNo;
  }

  public User(String name, int age, String address, String rollNo, List<String> courses){
    this.name=name;
    this.age=age;
    this.address=address;
    this.rollNo=rollNo;
    this.courses=courses;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", address='" + address + '\'' +
        ", rollNo=" + rollNo +
        ", courses=" + courses +
        '}';
  }

  @Override
  public int compareTo(User o) {
    return 0;
  }
}
