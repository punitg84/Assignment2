package studentdirectory.models;

import static studentdirectory.models.User.CreateUserWithRollNo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class UserCollection {

  private static final UserCollection USER_COLLECTION = new UserCollection();

  private final HashSet<User> userSet = new HashSet<>();

  public static UserCollection getInstance() {
    return USER_COLLECTION;
  }

  public void addUser(final User user) {
    userSet.add(user);
  }

  public void deleteUser(final String rollNo) {
    userSet.remove(CreateUserWithRollNo(rollNo));
  }

  public boolean isUserWithGivenRollNoPresent(final String rollNo) {
    return userSet.contains(CreateUserWithRollNo(rollNo));
  }

  public void clearUserList() {
    userSet.clear();
  }

  public List<User> getUserList() {
    return new ArrayList<>(userSet);
  }

  private UserCollection() {

  }
}
