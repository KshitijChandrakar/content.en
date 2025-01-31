public class SecondLargetElement {
    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 8, 25, 22};

        if (arr.length < 2) {
            System.out.println("Array must have at least two elements.");
            return;
        }

        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }

        System.out.println("Second largest element: " + (second == Integer.MIN_VALUE ? "No second largest" : second));
    }
}
