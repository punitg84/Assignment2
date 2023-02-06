package studentdirectory.models;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import lombok.Setter;
import studentdirectory.utils.FileUtility;

@Setter
public class UserCollection {

  private static UserCollection userCollectionInstance;

  private FileUtility fileUtility;
  private final SortedSet<User> userSet;
  private final Map<String, User> rollNoUserMapping;

  private UserCollection() throws Exception {
    userSet = new TreeSet<>();
    rollNoUserMapping = new HashMap<>();
    fileUtility = new FileUtility();
    loadData();
  }

  public static UserCollection getInstance() throws Exception {
    if (Objects.isNull(userCollectionInstance)) {
      userCollectionInstance = new UserCollection();
    }
    return userCollectionInstance;
  }

  public void loadData() throws Exception {
    clearUserList();
    final List<User> users = (List<User>) fileUtility.readObjectFromFile();
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

  public void saveUsers() throws Exception {
    fileUtility.writeObjectToFile(getUserList());
  }

}
