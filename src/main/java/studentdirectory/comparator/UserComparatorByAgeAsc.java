package studentdirectory.comparator;

import java.util.Comparator;
import studentdirectory.models.User;

public class UserComparatorByAgeAsc implements Comparator<User> {
  @Override
  public int compare(final User o1, final User o2) {
    return Integer.compare(o1.getAge(), o2.getAge());
  }
}
