abstract class Employee {
    protected String name;
    protected String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public abstract void calculateSalary();
    public abstract void displayDetails();
}
