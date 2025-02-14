// Create a Calculator class that contains a method add() to perform addition. Overload the
// add() method to handle different types and numbers of parameters, such as adding two
// integers, two doubles, and three integers. Create an object of the class and demonstrate all
// method variations.
// Define the Calculator class
class Calculator1 {

    // Method 1: Add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method 2: Add two doubles
    public double add(double a, double b) {
        return a + b;
    }

    // Method 3: Add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

// Main class to test the Calculator
public class Calculator {
    public static void main(String[] args) {
        // Create an object of Calculator
        Calculator1 calc = new Calculator1();

        // Demonstrating overloaded methods
        System.out.println("Sum of two integers: " + calc.add(5, 10));
        System.out.println("Sum of two doubles: " + calc.add(5.5, 10.2));
        System.out.println("Sum of three integers: " + calc.add(5, 10, 15));
    }
}
