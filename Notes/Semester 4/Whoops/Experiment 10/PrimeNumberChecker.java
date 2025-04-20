import java.util.ArrayList;

public class PrimeNumberChecker {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<>();
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
    numbers.add(5);
    numbers.add(6);
    numbers.add(7);
    numbers.add(8);
    numbers.add(9);
    numbers.add(10);
    numbers.add(11);
    numbers.add(12);
    numbers.add(13);

    for (Integer num : numbers) {
      int n = num; // Unboxing
      boolean isPrime = isPrimeNumber(n);
      System.out.println(n + " is " + (isPrime ? "prime" : "not prime"));
    }
  }

  private static boolean isPrimeNumber(int number) {
    if (number <= 1) {
      return false;
    }
    if (number == 2) {
      return true;
    }
    if (number % 2 == 0) {
      return false;
    }
    for (int i = 3; i * i <= number; i += 2) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
