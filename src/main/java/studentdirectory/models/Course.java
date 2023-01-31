package studentdirectory.models;

import studentdirectory.enums.CourseType;

public class Course {

  private CourseType type;

  public Course(String type) throws Exception {
    this.type = getType(type);
  }

  private static CourseType getType(String type) throws Exception {
    try {
      return CourseType.valueOf(type);
    } catch (Exception e) {
      throw new Exception("CourseType are need to have the following values only: A,B,C,D,E and F", e);
    }
  }

}
