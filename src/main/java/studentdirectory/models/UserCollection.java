package studentdirectory.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public final class UserCollection {

  private static final UserCollection USER_COLLECTION = new UserCollection();

  private final TreeSet<User> userSet = new TreeSet<>();

  private final HashMap<String,User> rollNoUserMapping = new HashMap<>();

  public static UserCollection getInstance() {
    return USER_COLLECTION;
  }

  public void addUser(final User user) {
    userSet.add(user);
    rollNoUserMapping.put(user.getRollNo(),user);
  }

  public void deleteUser(final String rollNo) {
    User user = rollNoUserMapping.get(rollNo);
    userSet.remove(user);
    rollNoUserMapping.remove(rollNo);
  }

  public boolean isUserWithGivenRollNoPresent(final String rollNo) {
    return rollNoUserMapping.containsKey(rollNo);
  }

  public void clearUserList() {
    userSet.clear();
    rollNoUserMapping.clear();
  }

  public List<User> getUserList() {
    return new ArrayList<>(userSet);
  }

  private UserCollection() {

  }
}
