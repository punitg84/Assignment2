package studentdirectory.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import studentdirectory.enums.CourseType;


public class User implements Serializable, Comparable<User> {

  private static final String NAME_EMPTY_MESSAGE = "Name cant be empty or null";
  private static final String AGE_MIN_MESSAGE = "Age should not be less than 3";
  private static final String AGE_MAX_MESSAGE = "Age should not be greater than 100";
  private static final String ADDRESS_SIZE_MESSAGE = "Address must be longer than 10 char but less than 50 char";
  private static final String ROLL_NO_EMPTY_MESSAGE = "Roll No cannot be empty";

  @Serial
  private static final long serialVersionUID = 101;

  @NotEmpty(message = NAME_EMPTY_MESSAGE)
  private final String name;

  @Min(value = 3, message = AGE_MIN_MESSAGE)
  @Max(value = 100, message = AGE_MAX_MESSAGE)
  private final int age;

  @Size(min = 10, max = 50, message = ADDRESS_SIZE_MESSAGE)
  private final String address;

  @NotEmpty(message = ROLL_NO_EMPTY_MESSAGE)
  private final String rollNo;

  @Size(min = 4, max = 4)
  private final List<CourseType> courses;

  public User(final String name, final int age, final String address, final String rollNo,
              final List<CourseType> courses) {

    this.name = name;
    this.age = age;
    this.address = address;
    this.rollNo = rollNo;
    this.courses = courses;

  }

  public String getName() {
    return name;
  }

  public String getRollNo() {
    return rollNo;
  }

  public int getAge() {
    return age;
  }

  public String getAddress() {
    return address;
  }

  @Override
  public int hashCode() {
    return rollNo.hashCode();
  }

  @Override
  public boolean equals(final Object obj) {

    if (obj == this) {
      return true;
    }

    if (!(obj instanceof User)) {
      return false;
    }

    final User otherUser = (User) obj;
    return rollNo.compareTo(otherUser.getRollNo()) == 0;

  }

  @Override
  public int compareTo(final User o) {

    if (name.equals(o.getName())) {
      return rollNo.compareTo(o.getRollNo());
    }

    return name.compareTo(o.getName());

  }

  @Override
  public String toString() {
    return "Student{" + "name='" + name + '\'' + ", age=" + age + ", address='" + address + '\''
        + ", rollNo=" + rollNo + ", courses=" + courses + '}';
  }
}
