public class Main {
    public static void main(String[] args) {
        Employee manager = new Manager("Manager Name", 5000.0);
        manager.calculateSalary();
        manager.displayDetails();

        Employee developer = new Developer("Developer Name", 25.0, 160);
        developer.calculateSalary();
        developer.displayDetails();
    }
}
