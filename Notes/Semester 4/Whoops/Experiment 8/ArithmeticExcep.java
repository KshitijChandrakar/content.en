// Write a Java program that takes two integers as input from the user and
// performs division.
// Handle the ArithmeticException that occurs if the denominator is zero. Use a
// try-catch block
// to catch the exception and display an appropriate error message.
// Additionally, use a finally
// block to print "Operation completed" regardless of whether an exception
// occurs or not.
class ArithmeticExcep {
  public static void main(String[] args) {
    try {

      if (Integer.parseInt(args[1]) == 0) {
        throw new ArithmeticException("Division by zero!");
      }

      System.out.println(args[0] + "/" + args[1] + "=" + Float.parseFloat(args[0]) / Float.parseFloat(args[1]));
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("ERR: You forgot the Args again didnt you");
    } catch (ArithmeticException e) {
      System.out.println("ERR: Oh crap its an infinity again");
    } finally {
      System.out.println("ITS DONE");
    }

  }
}
