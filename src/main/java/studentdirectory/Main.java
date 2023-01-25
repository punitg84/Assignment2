package studentdirectory;

import static studentdirectory.validation.InputValidator.sortOptionValidator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import studentdirectory.controller.FileController;
import studentdirectory.controller.UserCollectionController;
import studentdirectory.enums.SortOrder;

public class Main {
  private static Scanner scanner = new Scanner(System.in);
  private static boolean isUserExited;

  public static void main(String[] args) {
    loadData();
    while (!isUserExited) {
      showMenu();
    }
  }

  static void loadData() {
    try {
      FileController.readUserDetailsFromFile();
    } catch (Exception e) {
      showErrors(e.getMessage());
      isUserExited = true;
    }
  }

  static void showErrors(final String errMessage) {
    System.out.println("The given request could not be processed due to the following error:");
    System.out.println(errMessage);
  }

  static void showMenu() {
    System.out.println(
        "Select one of the 5 options available by entering number\n" + "1. Add User Details\n" +
            "2. Display User Details\n" + "3. Delete User Details\n" + "4. Save User Details\n" +
            "5. Exit");
    selectOptionFromMenu();
  }

  static void selectOptionFromMenu() {
    try {
      final String option = scanner.nextLine();
      switch (option) {
        case "1" -> addUser();
        case "2" -> displayUser();
        case "3" -> deleteUser();
        case "4" -> saveUser();
        case "5" -> exitUser();
        default -> {
          System.out.println(
              "Given input is incorrect select an option between 1-5, Please re enter");
          selectOptionFromMenu();
        }
      }
    } catch (Exception e) {
      showErrors(e.getMessage());
    }
  }

  static void addUser() throws Exception {
    System.out.println(
        "Give the input in following order line by line\n" + "1. Full name\n" + "2. Age\n" +
            "3. Roll No\n" + "4. Address\n" + "5. 4 courses from A,B,C,D,E or F in 4 lines");

    final String fullName = scanner.nextLine();
    final String age = scanner.nextLine();
    final String rollNo = scanner.nextLine();
    final String address = scanner.nextLine();
    final List<String> courses = new ArrayList<>();
    for (int i = 1; i <= 4; i++) {
      final String courseName = scanner.nextLine();
      courses.add(courseName);
    }

    UserCollectionController.addUser(fullName, age, address, rollNo, courses);

    System.out.println("The User got entered successfully");
  }

  static void displayUser() throws Exception {
    System.out.println("Select order in which data needs to be sorted\n" +
        "1. According to age in ascending order\n" + "2. According to age in descending order\n" +
        "3. According to name in ascending order\n" + "4. According to name in descending order\n" +
        "5. According to address in ascending order\n" +
        "6. According to address in descending order\n" +
        "7. According to roll no in ascending order\n" +
        "8. According to roll no in descending order\n");

    final String option = scanner.nextLine();
    sortOptionValidator(option);
    final int optionNumber = Integer.parseInt(option);
    final SortOrder sortOrder = SortOrder.get(optionNumber);

    System.out.println(UserCollectionController.getUserListSortedByOrder(sortOrder));
  }

  static void deleteUser() throws Exception {
    System.out.println("Enter the roll no of the user to be deleted");
    final String rollNo = scanner.nextLine();

    UserCollectionController.deleteUser(rollNo);

    System.out.println("The User got deleted successfully");
  }


  static void saveUser() throws Exception {
    System.out.println("All the User details are being save to the file...");

    FileController.writeUserDetailsToFile();

    System.out.println("The Details have been successfully saved");
  }

  static void exitUser() throws Exception {
    System.out.println(
        "Do you wish to save the details, Enter yes if interested or else press enter");

    final String choice = scanner.nextLine();
    if ("yes".equalsIgnoreCase(choice)) {
      saveUser();
    }

    System.out.println("The application is exiting");
    isUserExited = true;
  }

}
