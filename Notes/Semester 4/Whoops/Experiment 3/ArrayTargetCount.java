import java.util.Scanner;
import java.util.Arrays;
public class ArrayTargetCount {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9, 2, 3,3}; // Example array
        System.out.print("Array Is: ");
        System.out.println(Arrays.toString(numbers));
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the target number: ");
        int target = scanner.nextInt();
        scanner.close();

        int count = 0;
        for (int num : numbers) {
            if (num == target) {
                count++;
            }
        }

        System.out.println("Count of " + target + ": " + count);
    }
}
