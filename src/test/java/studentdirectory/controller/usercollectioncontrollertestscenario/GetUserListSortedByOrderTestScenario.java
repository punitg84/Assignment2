package studentdirectory.controller.usercollectioncontrollertestscenario;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import studentdirectory.enums.SortOrderType;
import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

@Getter
@Setter
public class GetUserListSortedByOrderTestScenario extends GenericTestScenario {
  List<User> randomUserList = new ArrayList<>();
  List<User> sortedUserList = new ArrayList<>();
  SortOrderType order;

}
