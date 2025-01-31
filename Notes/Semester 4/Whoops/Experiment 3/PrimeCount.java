import java.util.Scanner;

public class PrimeCount {
    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter start of range: ");
        int start = scanner.nextInt();
        System.out.print("Enter end of range: ");
        int end = scanner.nextInt();
        scanner.close();

        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) count++;
        }

        System.out.println("Total prime numbers: " + count);
    }
}
