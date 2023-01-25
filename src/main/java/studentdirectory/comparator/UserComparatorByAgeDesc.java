package studentdirectory.comparator;

import java.util.Comparator;
import studentdirectory.models.User;

public class UserComparatorByAgeDesc implements Comparator<User> {

  @Override
  public int compare(final User o1, final User o2) {
    return Integer.compare(o2.getAge(), o1.getAge());
  }
}
