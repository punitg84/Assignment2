package studentdirectory.validation;

import java.util.Map;
import java.util.TreeMap;
import studentdirectory.models.User;
import studentdirectory.models.UserCollection;
public class UserCollectionValidator {

  private static boolean isRollNoPresent(final String rollNo){
    final UserCollection userCollection = UserCollection.getInstance();
    final Map<String, User> userMap = userCollection.getUserMap();
    return userMap.containsKey(rollNo);
  }

  public static void validateRollNoAbsent(final String rollNo) throws Exception{
    if(isRollNoPresent(rollNo)){
      throw new Exception("Roll No is already present in the database");
    }
  }

  public static void validateRollNoPresent(final String rollNo) throws Exception{
    if(!isRollNoPresent(rollNo)){
      throw new Exception("Roll No is not present in the database");
    }
  }
}
