package studentdirectory.comparator;

import java.util.Comparator;
import studentdirectory.models.User;

public class UserComparatorByRollNoDesc implements Comparator<User> {

  @Override
  public int compare(final User o1, final User o2) {
    return o2.getRollNo().compareTo(o1.getRollNo());
  }
}
