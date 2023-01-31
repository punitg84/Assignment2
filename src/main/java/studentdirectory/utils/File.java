package studentdirectory.utils;

import static studentdirectory.constants.Path.FILE_PATH;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class File {

  private static final String APPLICATION_PATH = System.getProperty("user.dir");
  private static final Path PATH = Paths.get(APPLICATION_PATH, FILE_PATH);

  public static void writeObjectToFile(Object obj) throws Exception {
    try (ObjectOutputStream outputStream = new ObjectOutputStream(
        new BufferedOutputStream(Files.newOutputStream(PATH)))) {

      outputStream.writeObject(obj);

    } catch (Exception e) {
      throw new Exception("Not able to process the file", e);
    }
  }

  private static void createNewFile() throws Exception {
    try {
      final java.io.File fileObj = new java.io.File(PATH.toUri());
      fileObj.createNewFile();
    } catch (Exception e) {
      throw new Exception("File not available and cant be created", e);
    }
  }

  public static Object readObjectFromFile() throws Exception {
    try (ObjectInputStream inputStream = new ObjectInputStream(
        new BufferedInputStream(Files.newInputStream(PATH)))) {

      return inputStream.readObject();

    } catch (NoSuchFileException e) {
      createNewFile();
    } catch (EOFException e) {

      final java.io.File file = new java.io.File(PATH.toUri());
      if (file.length() != 0) {
        throw new Exception("Not able to read file", e);
      }

    } catch (Exception e) {
      throw new Exception("Not able to process file", e);
    }
    return null;
  }

}
