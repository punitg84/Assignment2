package studdir;

import jakarta.validation.ConstraintViolation;
import java.util.Scanner;
import java.util.Set;
import studdir.models.Student;

public class Main {
  //show menu
  // add user
  //display user
  //delete user
  //save user
  //terminate
  static void showErrors(Set<ConstraintViolation<Student>> errors){

  }
  static void showMenu(){
    //Show options 1-5
    //output sare
    //selectOptionForMenu()
  }

  static void showExitMenu(){

  }

  static void selectOptionForMenu(){
    //Default recall
  }


  static void addStudent(){
    //Input output
    //Error list
    //Call show errors if list not empty
  }

  static void deleteStudent(){
    //Input output
    //Error list
    //Call show errors if list not empty
  }

  static void displayStudent(){
    //Input output
  }

  static void displayStudentList(String order){

  }


  static void saveUser(){
    //output thora
    //file controller
  }
  public static void main(String[] args){
    while(true){
      showMenu();
    }
  }
}
