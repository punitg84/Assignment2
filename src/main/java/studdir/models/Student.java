package studdir.models;

import java.io.Serializable;
import java.util.ArrayList;
public class Student implements Serializable, Comparable<Student> {

  private String name;
  public int age;
  private String address;
  private String rollNo;
  private ArrayList<String> courses = new ArrayList<>();

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setRollNo(String rollNo) {
    this.rollNo = rollNo;
  }

  public void setCourses(ArrayList<String> courses) {
    this.courses = courses;
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
  public int compareTo(Student o) {
    return 0;
  }
}
