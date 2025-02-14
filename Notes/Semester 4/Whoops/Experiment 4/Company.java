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
