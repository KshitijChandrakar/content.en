class Employee {
    protected String name;
    protected int empid;
    protected double salary;

    public Employee() {
        this.name = "Default Name";
        this.empid = 0;
        this.salary = 0.0;
    }

    public Employee(String name, int empid, double salary) {
        this.name = name;
        this.empid = empid;
        this.salary = salary;
    }

    public String getName() {
        System.out.println("Name is " + name);
        return name;
    }

    public double getSalary() {
        System.out.println("Salary of " + name + " is " + salary);
        return salary;
    }

    public void increaseSalary(double percentage) {
        salary += salary * (percentage / 100);
        System.out.println("New Salary: " + salary);
    }
}

class Manager extends Employee {
    private String department;

    public Manager(String name, int empid, double salary, String department) {
        super(name, empid, salary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String getName() {
        System.out.println(name + " (Manager of " + department + ")");
        return name + " (Manager of " + department + ")";
    }
}

public class EmployeeSalary {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Caterpillar", 101, 50000);
        emp1.getName();
        emp1.getSalary();
        emp1.increaseSalary(10);

        System.out.println("--------------");

        Manager emp2 = new Manager("Butterfly", 201, 70000, "IT");
        emp2.getName();
        emp2.getSalary();
        emp2.increaseSalary(15);
    }
}
