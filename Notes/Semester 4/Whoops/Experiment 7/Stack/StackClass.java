import java.util.Scanner;

interface StackInterface {
    void push(int item);
    int pop();
    void display();
}

class StackClass implements StackInterface {
    private int[] stackArray;
    private int top;
    private int capacity;

    public StackClass(int size) {
        stackArray = new int[size];
        capacity = size;
        top = -1;
    }

    @Override
    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + item);
        } else {
            System.out.println("Pushing " + item + " to the stack");
            stackArray[++top] = item;
        }
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop from empty stack");
            return -1;
        } else {
            System.out.println("Popping " + stackArray[top] + " from the stack");
            return stackArray[top--];
        }
    }

    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack contents:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stackArray[i]);
            }
        }
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == capacity - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();

        StackClass stack = new StackClass(size);

        while (true) {
            System.out.println("\nStack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the number to push: ");
                    int num = scanner.nextInt();
                    stack.push(num);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
