// A company wants to develop an Employee Management System to track employee details
// such as name, department, salary, and employee ID. The system should also calculate the
// total salary expenditure and keep a record of the total number of employees. Implement a
// Java program by creating an Employee class that includes instance variables for employee
// ID, name, department, and salary. The class should have a default constructor that
// initializes employee details with default values and a parameterized constructor that sets
// employee details based on user input. Use a static variable totalEmployees to track the total
// number of employees and implement a static method to display this count. Additionally,
// define a method calculateSalary() that returns the salary of the employee and another
// method displayEmployeeInfo() to display all employee details. To ensure data
// encapsulation, mark the salary variable as private and provide a public method to access it.
// Declare the totalEmployees variable as static so that it is shared among all instances. In the
// main method, create multiple Employee objects using both default and parameterized
// constructors. Use the this keyword in the constructors to distinguish between class
// variables and constructor parameters. Finally, display the total number of employees and
// the salary details for each employee. The program should successfully demonstrate the
// behavior of static and non-static members, the initialization of objects using constructors,
// and the role of access modifiers in an employee management scenari


// Main Company Class
public class Company {
  static final int Employee_Count = 10;
  static private Employee[] Employees = new Employee[Employee_Count];



  // Main
  public static void main(String[] args) {
    Employees[0] = new Employee();
    for (int i = 1; i < Employees.length ; i++) {
      Employees[i] = new Employee("Name", "Department", 10);
    }
    System.out.println("Total Number Of Employees: " + Employee.TotalEmployees());
    TotalSalary();
    for (int i = 1; i < Employees.length ; i++) {
      Employees[i].DisplayEmployeeInfo();
    }
  }

  // Total Salary
  public static double TotalSalary(){
    double total = 0;
    for (Employee Emp : Employees) {
      total += Emp.calculateSalary();
    }
    System.out.println("Total Expenditure: " + total);
    return total;
  }
}


// Employee Class
class Employee{
  static int totalEmployees;
  int ID;
  String name;
  String department;
  private double salary;


  Employee(){
    this.ID = totalEmployees + 1;
    this.name = "Default Name";
    this.department = "Default Department";
    this.salary = 0;
    totalEmployees += 1;
  }
  Employee(String name, String department, double salary){
    this.ID = totalEmployees + 1;
    this.name = name;
    this.department = department;
    this.salary = salary;
    totalEmployees += 1;
  }

  public double calculateSalary(){
    // System.out.println("Salary for ID " + ID + " is " + this.salary);
    return salary;
  }
  public static int TotalEmployees(){
    return totalEmployees;
  }

  public void DisplayEmployeeInfo(){
    System.out.println("----- Employee Details-----");
    System.out.println("ID: " + ID);
    System.out.println("Name: " + name);
    System.out.println("Department: " + department);
    System.out.println("Salary: " + salary);
    System.out.println("----------");
  }
}
