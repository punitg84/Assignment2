package studentdirectory.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public final class UserCollection {

  private static UserCollection userCollectionInstance;

  private final SortedSet<User> userSet;
  private final Map<String, User> rollNoUserMapping;

  private UserCollection() {
    userSet = new TreeSet<>();
    rollNoUserMapping = new HashMap<>();
  }

  public static UserCollection getInstance() {
    if (Objects.isNull(userCollectionInstance)) {
      userCollectionInstance = new UserCollection();
    }
    return userCollectionInstance;
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

  public boolean isUserPresent(final String rollNo) {
    return rollNoUserMapping.containsKey(rollNo);
  }

}
