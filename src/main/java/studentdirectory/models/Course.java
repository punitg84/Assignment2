package studentdirectory.models;

import lombok.Getter;
import lombok.Setter;
import studentdirectory.enums.CourseName;

@Getter
@Setter
public class Course {

  private CourseName courseName;

  public Course(String courseName) throws Exception {
    this.courseName = getCourseName(courseName);
  }

  private static CourseName getCourseName(String name) throws Exception {
    try {
      return CourseName.valueOf(name);
    } catch (Exception e) {
      throw new Exception("CourseName are need to have the following values only: A,B,C,D,E and F", e);
    }
  }

}
