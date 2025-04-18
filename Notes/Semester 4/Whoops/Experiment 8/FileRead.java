
// Write a Java program that reads the contents of a file named student.txt
// using FileReader and
// displays the data on the console. Handle FileNotFoundException if the file
// does not exist and
// display an appropriate error message. Use a try-catch block for exception
// handling.
import java.io.*;

class FileRead {
  public static void main(String[] args) throws IOException {

    // Reading File name
    String path;
    try {
      path = args[0];

      FileReader fr = new FileReader(path);

      int i;

      while ((i = fr.read()) != -1)
        System.out.print((char) i);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("ARGS ARGS ARGSSS");
    }
  }
}
