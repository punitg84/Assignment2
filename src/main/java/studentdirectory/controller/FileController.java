package studentdirectory.controller;

import static studentdirectory.constants.Path.FILE_PATH;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import studentdirectory.models.User;
import studentdirectory.models.UserCollection;

public class FileController {

  private static final String APPLICATION_PATH = System.getProperty("user.dir");
  private static final Path path = Paths.get(APPLICATION_PATH, FILE_PATH);

  public static void writeUserDetailsToFile() throws Exception {
    try (ObjectOutputStream outputStream = new ObjectOutputStream(
        new BufferedOutputStream(Files.newOutputStream(path)))) {
      final List<User> userList = UserCollection.getInstance().getUserList();
      outputStream.writeObject(userList.size());
      for (final User user : userList) {
        outputStream.writeObject(user);
      }
    } catch (NoSuchFileException e) {
      createNewFile();
    } catch (Exception e) {
      throw new Exception("Not Able to process the file hence terminating");
    }
  }

  public static void readUserDetailsFromFile() throws Exception {
    try (ObjectInputStream inputStream = new ObjectInputStream(
        new BufferedInputStream(Files.newInputStream(path)))) {
      int userListSize = (int) inputStream.readObject();
      final UserCollection userCollection = UserCollection.getInstance();
      while (userListSize-- != 0) {
        final User user = (User) inputStream.readObject();
        userCollection.addUser(user);
      }
    } catch (NoSuchFileException e) {
      createNewFile();
    } catch (EOFException e) {
      File file = new File(path.toUri());
      if (file.length() != 0) {
        throw new Exception("Error while reading data, Terminating");
      }
    } catch (Exception e) {
      throw new Exception("Not Able to process the file hence terminating");
    }
  }

  private static void createNewFile() throws Exception {
    try {
      final File fileObj = new File(path.toUri());
      fileObj.createNewFile();
    } catch (Exception e) {
      throw new Exception("File is not available and can't be created");
    }
  }
}
