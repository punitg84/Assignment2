package studentdirectory.controller;

import static studentdirectory.validation.UserCollectionValidator.validateRollNoAbsent;
import static studentdirectory.validation.UserCollectionValidator.validateRollNoPresent;

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

public final class UserCollectionController {
  public static void addUser(final String name,
                             final String age,
                             final String address,
                             final String rollNo,
                             final List<String> courses) throws Exception {

    validateRollNoAbsent(rollNo);
    final User user = UserController.createUser(name, age, address, rollNo, courses);
    final UserCollection userCollection = UserCollection.getInstance();
    userCollection.addUser(user);

  }

  public static void deleteUser(final String rollNo) throws Exception {

    validateRollNoPresent(rollNo);
    final UserCollection userCollection = UserCollection.getInstance();
    userCollection.deleteUser(rollNo);

  }

  public static List<User> getUserListSortedByOrder(final SortOrderType sortOrderType) {

    final List<User> userList = UserCollection.getInstance().getUserList();

    switch (sortOrderType) {
      case AGE_ASC -> userList.sort(new UserComparatorByAgeAsc());
      case AGE_DESC -> userList.sort(new UserComparatorByAgeDesc());
      case NAME_ASC -> userList.sort(new UserComparatorByNameAsc());
      case NAME_DESC -> userList.sort(new UserComparatorByNameDesc());
      case ROLL_NO_ASC -> userList.sort(new UserComparatorByRollNoAsc());
      case ROLL_NO_DESC -> userList.sort(new UserComparatorByRollNoDesc());
      case ADDRESS_ASC -> userList.sort(new UserComparatorByAddressAsc());
      case ADDRESS_DESC -> userList.sort(new UserComparatorByAddressDesc());
    }

    return userList;
  }


  private UserCollectionController() {

  }
}
