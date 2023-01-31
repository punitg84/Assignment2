package studentdirectory.controller;

import static studentdirectory.utils.File.writeObjectToFile;

import java.util.List;
import studentdirectory.comparator.UserComparatorByAddressAsc;
import studentdirectory.comparator.UserComparatorByAddressDesc;
import studentdirectory.comparator.UserComparatorByAgeAsc;
import studentdirectory.comparator.UserComparatorByAgeDesc;
import studentdirectory.comparator.UserComparatorByNameAsc;
import studentdirectory.comparator.UserComparatorByNameDesc;
import studentdirectory.comparator.UserComparatorByRollNoAsc;
import studentdirectory.comparator.UserComparatorByRollNoDesc;
import studentdirectory.enums.SortOrderType;
import studentdirectory.models.User;
import studentdirectory.models.UserCollection;

public final class UserCollectionRepo {

  private UserCollection collection;

  public UserCollectionRepo(UserCollection collection) {
    this.collection = collection;
  }

  private boolean isRollNoPresent(final String rollNo) {
    return collection.isUserPresent(rollNo);
  }

  public void addUser(User user) throws Exception {

    if (isRollNoPresent(user.getRollNo())) {
      throw new Exception(
          String.format("Roll No(%s) is already present in the database", user.getRollNo()));
    }

    collection.addUser(user);

  }

  public void addUsers(List<User> users) throws Exception {
    for (User user : users) {
      addUser(user);
    }
  }

  public void deleteUser(final String rollNo) throws Exception {

    if (!isRollNoPresent(rollNo)) {
      throw new Exception(String.format("Roll No(%s) is not present in the database", rollNo));
    }
    collection.deleteUser(rollNo);

  }

  public List<User> getSortedUserList(final SortOrderType sortOrderType) throws Exception {

    final List<User> userList = collection.getUserList();

    switch (sortOrderType) {
      case AGE_ASC -> userList.sort(new UserComparatorByAgeAsc());
      case AGE_DESC -> userList.sort(new UserComparatorByAgeDesc());
      case NAME_ASC -> userList.sort(new UserComparatorByNameAsc());
      case NAME_DESC -> userList.sort(new UserComparatorByNameDesc());
      case ROLL_NO_ASC -> userList.sort(new UserComparatorByRollNoAsc());
      case ROLL_NO_DESC -> userList.sort(new UserComparatorByRollNoDesc());
      case ADDRESS_ASC -> userList.sort(new UserComparatorByAddressAsc());
      case ADDRESS_DESC -> userList.sort(new UserComparatorByAddressDesc());
      default -> throw new Exception(String.format("Wrong Sort order type: %s", sortOrderType));
    }

    return userList;
  }

  public void saveUsers() throws Exception {
    writeObjectToFile(collection.getUserList());
  }

}
