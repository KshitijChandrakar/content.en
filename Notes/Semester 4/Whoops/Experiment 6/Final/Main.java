public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.displayPI();
        circle.calculateArea(5.0);

        // Uncommenting this will cause a compilation error
        // MathConstants.PI = 3.14;
    }
}
