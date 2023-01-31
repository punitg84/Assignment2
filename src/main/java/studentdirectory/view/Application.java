package studentdirectory.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import studentdirectory.constants.UserChoice;
import studentdirectory.controller.UserCollectionRepo;
import studentdirectory.controller.UserController;
import studentdirectory.enums.SortOrderType;
import studentdirectory.models.UserCollection;

public class Application {

  private Scanner scanner = new Scanner(System.in);
  private boolean isUserExited;
  private UserCollectionRepo userCollectionRepo;
  private UserController userController;
  private UserCollection userCollection;

  public Application() {
    try {
      userCollection = UserCollection.getInstance();
      userCollectionRepo = new UserCollectionRepo(userCollection);
      userController = new UserController(userCollectionRepo);
    } catch (Exception e) {
      e.printStackTrace();
      showErrors(e);
      isUserExited = true;
    }
  }

  private int inputInteger() throws Exception {

    try {
      return scanner.nextInt();
    } catch (Exception e) {
      scanner.next();
      throw new Exception("Input is not integer", e);
    } finally {
      scanner.nextLine();      //Ignoring new line
    }

  }

  private void exitUser() throws Exception {

    System.out.println(
        "Do you wish to save the details, Enter yes if interested or else press enter");

    final String choice = scanner.nextLine();
    if (UserChoice.YES_CHOICE.equalsIgnoreCase(choice)) {
      saveUser();
    }

    System.out.println("The application is exiting");
    isUserExited = true;

  }

  private void saveUser() throws Exception {

    System.out.println("All the User details are being save to the file...");

    userCollectionRepo.saveUsers();

    System.out.println("The Details have been successfully saved");

  }

  private void deleteUser() throws Exception {

    System.out.println("Enter the roll no of the user to be deleted");
    final String rollNo = scanner.nextLine();

    userCollectionRepo.deleteUser(rollNo);

    System.out.println("The User got deleted successfully");

  }

  private void displayUser() throws Exception {

    System.out.println("Select order in which data needs to be sorted\n"
        + "1. According to age in ascending order\n"
        + "2. According to age in descending order\n"
        + "3. According to name in ascending order\n"
        + "4. According to name in descending order\n"
        + "5. According to address in ascending order\n"
        + "6. According to address in descending order\n"
        + "7. According to roll no in ascending order\n"
        + "8. According to roll no in descending order\n");

    final int optionNumber = inputInteger();
    final SortOrderType sortOrderType = SortOrderType.get(optionNumber);

    userCollectionRepo.getSortedUserList(sortOrderType).stream().forEach(System.out::println);

  }


  private void addUser() throws Exception {

    System.out.println(
        "Give the input in following order line by line\n"
            + "1. Full name\n"
            + "2. Age\n"
            + "3. Roll No\n"
            + "4. Address\n"
            + "5. 4 courses from A,B,C,D,E or F in 4 lines");

    final String fullName = scanner.nextLine();
    final int age = inputInteger();
    final String rollNo = scanner.nextLine();
    final String address = scanner.nextLine();
    final List<String> courses = new ArrayList<>();
    IntStream.rangeClosed(1, 4).forEach(i -> courses.add(scanner.nextLine()));

    userController.createUser(fullName, age, address, rollNo, courses);

    System.out.println("The User got entered successfully");

  }

  private void selectOptionFromMenu() {

    try {

      final int option = inputInteger();

      switch (option) {
        case UserChoice.ADD_OPTION_CHOICE -> addUser();
        case UserChoice.DISPLAY_OPTION_CHOICE -> displayUser();
        case UserChoice.DELETE_OPTION_CHOICE -> deleteUser();
        case UserChoice.SAVE_OPTION_CHOICE -> saveUser();
        case UserChoice.EXIT_OPTION_CHOICE -> exitUser();
        default -> throw new Exception("Given input is incorrect");
      }

    } catch (Exception e) {
      showErrors(e);
      e.printStackTrace();
    }

  }

  private void showMenu() {

    System.out.println(
        "Select one of the 5 options available by entering number\n"
            + "1. Add User Details\n"
            + "2. Display User Details\n"
            + "3. Delete User Details\n"
            + "4. Save User Details\n"
            + "5. Exit");
    selectOptionFromMenu();

  }

  private void showErrors(final Exception exception) {
    System.out.printf("The following error occurred :%s", exception.getMessage());
    //exception.printStackTrace();
  }

  public void run() {

    while (!isUserExited) {
      showMenu();
    }

  }

}
