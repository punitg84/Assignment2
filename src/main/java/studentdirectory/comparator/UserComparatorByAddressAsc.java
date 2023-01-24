package studentdirectory.comparator;

import java.util.Comparator;
import studentdirectory.models.User;

public class UserComparatorByAddressAsc implements Comparator<User> {
  @Override
  public int compare(User o1, User o2) {
    return o1.getAddress().compareTo(o2.getAddress());
  }
}
