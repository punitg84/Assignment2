package studentdirectory.controller;

import static studentdirectory.constants.Path.FILE_PATH;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import studentdirectory.models.User;
import studentdirectory.models.UserCollection;

public class FileController {


  private static final String APPLICATION_PATH = new File("").getAbsolutePath();

  public static void writeUserDetailsToFile() throws Exception {
    try (ObjectOutputStream outputStream = new ObjectOutputStream(
        new BufferedOutputStream(Files.newOutputStream(Paths.get(APPLICATION_PATH + FILE_PATH))))) {
      final UserCollection userCollection = UserCollection.getInstance();
      for (final User user : userCollection.getUserList()) {
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
        new BufferedInputStream(Files.newInputStream(Paths.get(APPLICATION_PATH + FILE_PATH))))) {
      final UserCollection userCollection = UserCollection.getInstance();
      while (true) {
        final User user = (User) inputStream.readObject();
        userCollection.addUser(user);
      }
    } catch (NoSuchFileException e) {
      createNewFile();
    } catch (Exception e) {
      throw new Exception("Not Able to process the file hence terminating");
    }
  }

  private static void createNewFile() throws Exception {
    try {
      File fileObj = new File(APPLICATION_PATH + FILE_PATH);
      fileObj.createNewFile();
    } catch (Exception e) {
      throw new Exception("File is not available and can't be created");
    }
  }
}
