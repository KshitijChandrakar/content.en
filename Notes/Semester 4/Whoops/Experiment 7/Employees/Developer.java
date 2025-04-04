class Developer extends Employee {
    private double hourlyWage;
    private int hoursWorked;

    public Developer(String name, double hourlyWage, int hoursWorked) {
        super(name, "Developer");
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public void calculateSalary() {
        double salary = hourlyWage * hoursWorked;
        System.out.println("Calculating Salary for Developer: " + salary);
    }

    @Override
    public void displayDetails() {
        double salary = hourlyWage * hoursWorked;
        System.out.println("Name: " + name + ", Role: " + role + ", Salary: " + salary);
    }
}
