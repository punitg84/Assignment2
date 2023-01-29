package studentdirectory.models;

import static studentdirectory.constants.ValidationMessage.ADDRESS_SIZE_MESSAGE;
import static studentdirectory.constants.ValidationMessage.AGE_MAX_MESSAGE;
import static studentdirectory.constants.ValidationMessage.AGE_MIN_MESSAGE;
import static studentdirectory.constants.ValidationMessage.NAME_EMPTY_MESSAGE;
import static studentdirectory.constants.ValidationMessage.ROLL_NO_EMPTY_MESSAGE;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import studentdirectory.enums.CourseType;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements Serializable, Comparable<User> {

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
  @EqualsAndHashCode.Include
  private final String rollNo;

  @Size(min = 4, max = 4)
  private final List<CourseType> courses;

  @Override
  public int compareTo(final User o) {

    if (name.equals(o.getName())) {
      return rollNo.compareTo(o.getRollNo());
    }

    return name.compareTo(o.getName());

  }
}
