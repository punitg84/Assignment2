package studdir.models;

import java.io.Serializable;
import java.util.HashSet;

//singleton pattern
public class StudentCollection implements Serializable {
  HashSet<Student> studentList = new HashSet<Student>();
  private static StudentCollection studentCollection = new StudentCollection();

  public static StudentCollection getInstance(){
    return studentCollection;
  }

  public void addStudent(Student student) {

  }

  public void deleteStudent(int rollNo){

  }

  public HashSet<Student> getStudentList() {
    return studentList;
  }

  private StudentCollection(){

  }
}
