
// Write a Java program that takes user input for a student's name, roll number,
// and grade, and
// writes this information to a file named student.txt using FileWriter. Ensure
// the program
// appends the data to the file if it already exists. Handle any exceptions
// using try-catch and
// display an appropriate message if an error occurs.
// Sample File Content:
// Name: Aman, Roll Number: 120112, Grade: A
// Name: Parul, Roll Number: 120131, Grade: B
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.util.Scanner;

class FileWrite {
  public static void fileAppend(String filename, String[] args) throws IOException {

    FileWriter fw = new FileWriter(filename, true);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write("Name: " + args[0] + " Roll No: " + args[1] + " Grade: " + args[2]);
    bw.newLine();
    bw.close();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Name:");
    String num1 = scanner.nextLine();
    System.out.println("Roll No:");
    String num2 = scanner.nextLine();
    System.out.println("Grade:");
    String num3 = scanner.nextLine();
    String s[] = { num1, num2, num3 };
    try {
      fileAppend(args[0], s);
    } catch (IndexOutOfBoundsException e) {
      System.err.println("Errraraarar: Dammit dude give the args man /jk \n" + e.getMessage());
    } catch (IOException e) {
      System.err.println(e.getMessage());
    } finally {
      scanner.close();
      System.out.println("ITS OVERR");
    }
  }
}
