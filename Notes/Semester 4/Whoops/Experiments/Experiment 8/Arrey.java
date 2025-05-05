// Write a Java program that creates an array of 5 integers and asks the user to
// enter an index to
// access the array element. Handle the ArrayIndexOutOfBoundsException if the
// user enters an
// invalid index. Use a try-catch block to catch the exception and display an
// appropriate error
// message. Use the finally block to print "Array access attempted."
class Arrey {
  public static void main(String[] args) {
    int[] arr = { 2, 3, 5, 7, 11 }; // Array literal
    try {
      System.out.println("Element is: " + arr[Integer.parseInt(args[0])]);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("ERR: You forgot the Args again didnt you\n" + e);
    } finally {
      System.out.println("ITS DONE");
    }
  }
}
