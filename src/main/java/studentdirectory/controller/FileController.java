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
  private static final Path PATH = Paths.get(APPLICATION_PATH, FILE_PATH);

  public static void writeUserDetailsToFile() throws Exception {
    try (ObjectOutputStream outputStream = new ObjectOutputStream(
        new BufferedOutputStream(Files.newOutputStream(PATH)))) {

      List<User> users = UserCollection.getInstance().getUserList();
      outputStream.writeObject(users);

    } catch (Exception e) {
      throw new Exception("Not Able to process the file hence terminating");
    }
  }

  private static void createNewFile() throws Exception {
    try {
      final File fileObj = new File(PATH.toUri());
      fileObj.createNewFile();
    } catch (Exception e) {
      throw new Exception("File is not available and can't be created");
    }
  }

  public static void readUserDetailsFromFile() throws Exception {
    try (ObjectInputStream inputStream = new ObjectInputStream(
        new BufferedInputStream(Files.newInputStream(PATH)))) {

      final UserCollection userCollection = UserCollection.getInstance();
      final List<User> users = (List<User>) inputStream.readObject();
      users.stream().forEach(userCollection::addUser);

    } catch (NoSuchFileException e) {
      createNewFile();
    } catch (EOFException e) {
      final File file = new File(PATH.toUri());
      if (file.length() != 0) {
        throw new Exception("Error while reading data, Terminating");
      }
    } catch (Exception e) {
      throw new Exception("Not Able to process the file hence terminating");
    }
  }
}
