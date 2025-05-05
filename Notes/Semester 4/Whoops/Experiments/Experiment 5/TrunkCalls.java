import java.util.Scanner;

class TrunkCall {
    protected double rate;

    public double computeCharge(int duration) {
        return duration * rate;
    }
}

class OrdinaryCall extends TrunkCall {
    public OrdinaryCall() {
        this.rate = 1.5;
    }
}

class UrgentCall extends TrunkCall {
    public UrgentCall() {
        this.rate = 2.5;
    }
}

class LightningCall extends TrunkCall {
    public LightningCall() {
        this.rate = 4.0;
    }
}


public class TrunkCalls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter call duration (in minutes): ");
        int duration = scanner.nextInt();

        System.out.println("Select Call Type:");
        System.out.println("1. Ordinary");
        System.out.println("2. Urgent");
        System.out.println("3. Lightning");
        System.out.print("Enter choice (1-3): ");
        int choice = scanner.nextInt();

        TrunkCall call;

        switch (choice) {
            case 1:
                call = new OrdinaryCall();
                break;
            case 2:
                call = new UrgentCall();
                break;
            case 3:
                call = new LightningCall();
                break;
            default:
                System.out.println("Invalid choice! Defaulting to Ordinary call.");
                call = new OrdinaryCall();
        }

        double totalCharge = call.computeCharge(duration);
        System.out.println("Total Trunk Call Charge: $" + totalCharge);

        scanner.close();
    }
}
