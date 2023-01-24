package studentdirectory.controller;

import static studentdirectory.constants.Path.FILE_PATH;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import studentdirectory.models.User;
import studentdirectory.models.UserCollection;

public class FileController {
  public static void writeUserDetailsToFile() throws Exception {
    final String home = System.getProperty("user.home");
    try (ObjectOutputStream outputStream = new ObjectOutputStream(
        new BufferedOutputStream(Files.newOutputStream(Paths.get(home + FILE_PATH))))) {
      final UserCollection userCollection = UserCollection.getInstance();
      for (final User user : userCollection.getUserList()) {
        outputStream.writeObject(user);
      }
    } catch (Exception e) {
      throw new Exception("File not found");
    }
  }

  public static void readUserDetailsFromFile() throws Exception {
    final String home = System.getProperty("user.home");
    try (ObjectInputStream inputStream = new ObjectInputStream(
        new BufferedInputStream(Files.newInputStream(Paths.get(home + FILE_PATH))))) {
      final UserCollection userCollection = UserCollection.getInstance();
      while (true) {
        final User user = (User) inputStream.readObject();
        userCollection.addUser(user);
      }
    } catch (EOFException e) {
      //File reading is completed
    } catch (Exception e) {
      throw new Exception("File not found");
    }
  }
}
