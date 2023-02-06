package studentdirectory.comparator;

import java.util.Comparator;
import studentdirectory.models.User;

public class UserComparatorByAddressDesc implements Comparator<User> {

  @Override
  public int compare(final User o1, final User o2) {
    return o2.getAddress().compareTo(o1.getAddress());
  }
}
