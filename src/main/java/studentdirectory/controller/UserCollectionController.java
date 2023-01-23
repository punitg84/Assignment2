package studentdirectory.controller;

import java.util.List;
import studentdirectory.models.User;

public class UserCollectionController {
  static void addUser(String name, String age, String address, String rollNo, List<String> courses) throws Exception{
    //call controller and fetch object
    //check for duplicate
    //add to list
  }

  static void deleteUser(String rollNo) throws Exception {
    //check if present
    //delete it
  }

  static List<User> getUserListSortedByOrder(String parameter, boolean isAscending){
    //convert into enum
    //run switch case to decide comparator and sort it using it
    return null;
  }
}
