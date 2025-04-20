import java.util.ArrayList;
import java.util.Iterator;

class Employee {
  private String name;
  private int id;
  private double salary;

  // Constructor
  public Employee(String name, int id, double salary) {
    this.name = name;
    this.id = id;
    this.salary = salary;
  }

  // Getters and Setters
  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Employee [Name: " + name + ", ID: " + id + ", Salary: $" + salary + "]";
  }
}

public class EmployeeManagement {
  public static void main(String[] args) {
    // Create ArrayList to store employees
    ArrayList<Employee> employees = new ArrayList<>();

    // Add three employees
    employees.add(new Employee("John Doe", 101, 50000.0));
    employees.add(new Employee("Jane Smith", 102, 60000.0));
    employees.add(new Employee("Bob Johnson", 103, 55000.0));

    System.out.println("Initial Employee List:");
    printEmployees(employees);

    // Update Jane's salary (ID 102)
    for (Employee emp : employees) {
      if (emp.getId() == 102) {
        emp.setSalary(65000.0);
        System.out.println("\nUpdated salary for Jane Smith (ID 102)");
        break;
      }
    }

    // Remove employee with ID 101 (John Doe)
    Iterator<Employee> iterator = employees.iterator();
    while (iterator.hasNext()) {
      Employee emp = iterator.next();
      if (emp.getId() == 101) {
        iterator.remove();
        System.out.println("Removed employee with ID 101");
        break;
      }
    }

    System.out.println("\nFinal Employee List:");
    printEmployees(employees);
  }

  // Helper method to print all employees
  private static void printEmployees(ArrayList<Employee> employees) {
    if (employees.isEmpty()) {
      System.out.println("No employees in the list");
      return;
    }

    for (Employee emp : employees) {
      System.out.println(emp);
    }
  }
}
