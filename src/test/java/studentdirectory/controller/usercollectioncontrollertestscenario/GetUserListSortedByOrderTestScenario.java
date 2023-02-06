package studentdirectory.controller.usercollectioncontrollertestscenario;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import studentdirectory.enums.SortOrderType;
import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
@Setter
public class GetUserListSortedByOrderTestScenario extends GenericTestScenario {
  List<User> randomUserList;
  List<User> sortedUserList;
  SortOrderType order;

  @Builder
  public GetUserListSortedByOrderTestScenario(String errMessage,
                                              String testCaseName,
                                              List<User> randomUserList,
                                              List<User> sortedUserList,
                                              SortOrderType order) {

    super(errMessage, testCaseName);
    this.randomUserList = randomUserList;
    this.sortedUserList = sortedUserList;
    this.order = order;
  }

}
