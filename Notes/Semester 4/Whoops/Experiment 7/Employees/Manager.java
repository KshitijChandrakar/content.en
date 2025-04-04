class Manager extends Employee {
    private double fixedSalary;

    public Manager(String name, double fixedSalary) {
        super(name, "Manager");
        this.fixedSalary = fixedSalary;
    }

    @Override
    public void calculateSalary() {
        System.out.println("Calculating Salary for Manager: " + fixedSalary);
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + name + ", Role: " + role + ", Salary: " + fixedSalary);
    }
}
