import java.util.Scanner;  // Import the Scanner class

class SimpleInterest{
  public static void main (String[] args){
    Scanner in = new Scanner(System.in);  // Create a Scanner object
      System.out.print("Enter Principle Amount: ");
      float Principle = in.nextFloat();
      System.out.print("Enter Interest in %: ");
      float Interest = in.nextFloat();
      Interest += 100;
      System.out.print("Enter Time: ");
      float Time = in.nextFloat();
      float Amount = Interest * Time * Principle / 100;
      System.out.println("Final Amount is " + Amount);
  }
}
