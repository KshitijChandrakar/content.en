//
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
// and the role of access modifiers in an employee management scenario.
class Worker {
    protected String name;
    protected double salaryRate;

    public Worker(String name, double salaryRate) {
        this.name = name;
        this.salaryRate = salaryRate;
    }

    public double computePay(int hours) {
        return salaryRate * hours;
    }
}

class DailyWorker extends Worker {
    public DailyWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    @Override
    public double computePay(int daysWorked) {
        return daysWorked * 8 * salaryRate;
    }
}

class SalariedWorker extends Worker {
    public SalariedWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    @Override
    public double computePay(int hours) {
        return 40 * salaryRate;
    }
}

public class WorkerSubclasses {
    public static void main(String[] args) {
        Worker dailyWorker = new DailyWorker("Daily Worker", 15.5);
        Worker salariedWorker = new SalariedWorker("Salaried Worker", 20.0);

        System.out.println(dailyWorker.name + "'s Weekly Pay: " + dailyWorker.computePay(5));
        System.out.println(salariedWorker.name + "'s Weekly Pay: " + salariedWorker.computePay(50));
    }
}
