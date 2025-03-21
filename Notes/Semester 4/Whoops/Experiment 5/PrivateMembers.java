class Parent {
    private int privateNumber = 42;
    public int getPrivateNumber() {
        return privateNumber;
    }
}
class Child extends Parent {
    public void display() {
        System.out.println("Accessing privateNumber through method: " + getPrivateNumber());
    }
    public void access() {
        System.out.println("Accessing privateNumber through method: " + privateNumber);
    }
}
public class PrivateMembers {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.display();
        // obj.access(); // Access Error
    }
}
