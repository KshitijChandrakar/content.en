class Worker {
    protected String name;
    protected double salaryRate;

    public Worker(String name, double salaryRate) {
        this.name = name;
        this.salaryRate = salaryRate;
    }

    public double computePay(int hours) {
        return 0;
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

        System.out.println(dailyWorker.name + "'s Weekly Pay: $" + dailyWorker.computePay(5));
        System.out.println(salariedWorker.name + "'s Weekly Pay: $" + salariedWorker.computePay(50));
    }
}
