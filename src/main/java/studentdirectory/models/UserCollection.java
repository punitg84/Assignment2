package studentdirectory.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public final class UserCollection {

  private static final UserCollection USER_COLLECTION = new UserCollection();

  private final SortedSet<User> userSet;

  private final Map<String, User> rollNoUserMapping;

  private UserCollection() {
    userSet=new TreeSet<>();
    rollNoUserMapping = new HashMap<>();
  }

  public static UserCollection getInstance() {
    return USER_COLLECTION;
  }

  public void addUser(final User user) {
    userSet.add(user);
    rollNoUserMapping.put(user.getRollNo(), user);
  }

  public void deleteUser(final String rollNo) {
    final User user = rollNoUserMapping.get(rollNo);
    userSet.remove(user);
    rollNoUserMapping.remove(rollNo);
  }

  public void clearUserList() {
    userSet.clear();
    rollNoUserMapping.clear();
  }

  public List<User> getUserList() {
    return new ArrayList<>(userSet);
  }

  public boolean isUserWithGivenRollNoPresent(final String rollNo) {
    return rollNoUserMapping.containsKey(rollNo);
  }
}
