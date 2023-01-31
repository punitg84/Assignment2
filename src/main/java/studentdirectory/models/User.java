package studentdirectory.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
import studentdirectory.constants.ValidationMessage;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements Serializable, Comparable<User> {

  @Serial
  private static final long serialVersionUID = 101;

  @NotEmpty(message = ValidationMessage.NAME_EMPTY_MESSAGE)
  private final String name;

  @Min(value = 3, message = ValidationMessage.AGE_MIN_MESSAGE)
  @Max(value = 100, message = ValidationMessage.AGE_MAX_MESSAGE)
  private final int age;

  @Size(min = 10, max = 50, message = ValidationMessage.ADDRESS_SIZE_MESSAGE)
  private final String address;

  @NotEmpty(message = ValidationMessage.ROLL_NO_EMPTY_MESSAGE)
  @EqualsAndHashCode.Include
  private final String rollNo;

  private final @Size(min = 4, max = 4) List<@NotNull Course> courses;

  @Override
  public int compareTo(final User o) {

    if (name.equals(o.getName())) {
      return rollNo.compareTo(o.getRollNo());
    }

    return name.compareTo(o.getName());

  }
}
