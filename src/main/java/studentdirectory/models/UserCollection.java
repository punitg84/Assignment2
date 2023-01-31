package studentdirectory.models;

import static studentdirectory.utils.File.readObjectFromFile;

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

  private UserCollection() throws Exception {
    userSet = new TreeSet<>();
    rollNoUserMapping = new HashMap<>();
    loadData();
  }

  public static UserCollection getInstance() throws Exception {
    if (Objects.isNull(userCollectionInstance)) {
      userCollectionInstance = new UserCollection();
    }
    return userCollectionInstance;
  }

  private void loadData() throws Exception {
    List<User> users = (List<User>) readObjectFromFile();
    if (Objects.nonNull(users)) {
      users.stream().forEach(this::addUser);
    }
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
