package studentdirectory;

public class Main {
  static void showMenu(boolean userNotExited){
    //Show options 1-5
    //output sare
    //selectOptionForMenu()
  }

  static void selectOptionForMenu(){
    //Default recall
    //catch mein showErrors
  }

  static void showErrors(String errMessage){

  }

  static void addUser() throws Exception{
    //Input output
    //user collection - err auto break
    //display success
  }

  static void deleteUser() throws Exception{
    //Input output
    //user collection - err auto break
    //display success
  }

  static void displayUser(){
    //Input output
    //get user list from user collection

  }

  static void saveUser() throws Exception{
    //output thora
    //file controller
    //display success
  }

  static void showExitMenu(){
    //output and choice to save
    //if save call save user
  }

  public static void main(String[] args){
    //Fetch user from file if present
    boolean userNotExited = true;
    do{
      showMenu(userNotExited);
    }while(userNotExited);
  }
}
