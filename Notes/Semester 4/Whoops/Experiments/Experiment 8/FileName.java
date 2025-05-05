
// Write a Java program that reads a file name from the user and attempts to
// open and read the
// file. Define a method readFile() that throws a FileNotFoundException using
// the throws
// keyword. In the main method, call this method and handle the exception using
// a try-catch
// block. Display an appropriate message if the file is not found. Use a finally
// block to ensure a
// message like "File operation attempted" is printed.

import java.io.File;
import java.io.FileNotFoundException;

class FileName {

  public static Boolean checkFileExists(String filePath) throws FileNotFoundException {
    File file = new File(filePath);
    if (!file.exists()) {
      throw new FileNotFoundException("File not found: " + filePath);
    } else {
      return true;
    }
  }

  public static void main(String[] args) {
    try {
      System.out.println(checkFileExists(args[0]) ? "YAY FOUND IT!!!! IT EXISTS CONGRATULATIONS EVERYONE IT EXISTS"
          : "nothing matters it doesnt exist");
    } catch (IndexOutOfBoundsException e) {
      System.err.println("Errraraarar: You forgot them args eh \n" + e.getMessage());
    } catch (FileNotFoundException e) {
      System.err.println("Erawr: " + e.getMessage());
    }
  }
}
