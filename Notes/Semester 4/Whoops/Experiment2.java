import java.util.Scanner;  // Import the Scanner class

class TriangleArea{
  public static void main (String[] args){
    Scanner in = new Scanner(System.in);  // Create a Scanner object
      System.out.print("Enter Height: ");
      float Height = in.nextFloat();
      System.out.print("Enter Base: ");
      float Base = in.nextFloat();
      float Area = Height * Base * 1 / 2;
      System.out.println("Area is " + Area);
  }
}
