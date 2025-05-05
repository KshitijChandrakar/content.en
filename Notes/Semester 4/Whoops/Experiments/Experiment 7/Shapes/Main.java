public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5.0, 10.0);
        rectangle.calculateArea();

        Shape circle = new Circle(7.0);
        circle.calculateArea();
    }
}
