package studentdirectory.comparator;

import java.util.Comparator;
import studentdirectory.models.User;

public class UserComparatorByNameDesc implements Comparator<User> {

  @Override
  public int compare(User o1, User o2) {
    return o2.getName().compareTo(o1.getName());
  }
}
