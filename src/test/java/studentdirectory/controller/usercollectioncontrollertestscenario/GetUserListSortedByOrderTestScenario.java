package studentdirectory.controller.usercollectioncontrollertestscenario;

import java.util.ArrayList;
import java.util.List;
import studentdirectory.enums.SortOrderType;
import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

public class GetUserListSortedByOrderTestScenario extends GenericTestScenario {
  List<User> randomUserList = new ArrayList<>();
  List<User> sortedUserList = new ArrayList<>();
  SortOrderType order;

  public List<User> getRandomUserList() {
    return randomUserList;
  }

  public void addUserInRandomUserList(User user) {
    randomUserList.add(user);
  }

  public List<User> getSortedUserList() {
    return sortedUserList;
  }

  public void addUserInSortedUserList(User user) {
    sortedUserList.add(user);
  }

  public SortOrderType getOrder() {
    return order;
  }

  public void setOrder(SortOrderType order) {
    this.order = order;
  }

}
