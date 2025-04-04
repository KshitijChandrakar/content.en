public class Circle extends MathConstants {
    public void calculateArea(double radius) {
        double area = PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }

    // Uncommenting this will cause a compilation error
    // @Override
    // public void displayPI() {
    //     System.out.println("Overridden PI: " + PI);
    // }
}
