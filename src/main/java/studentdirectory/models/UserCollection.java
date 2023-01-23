package studentdirectory.models;

import java.io.Serializable;
import java.util.HashSet;

//singleton pattern
public class UserCollection implements Serializable {
  HashSet<User> userList = new HashSet<User>();
  private static UserCollection userCollection = new UserCollection();

  public static UserCollection getInstance(){
    return userCollection;
  }

  public void addUser(User user) {

  }

  public void deleteUser(int rollNo){

  }

  public void clearUserList(){
    userList.clear();
  }

  public HashSet<User> getUserList() {
    return userList;
  }

  private UserCollection(){

  }
}
