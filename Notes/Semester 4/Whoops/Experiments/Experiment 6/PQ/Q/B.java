package Q;
import p.A;

public class B extends A{
    public static void main(String[] args) {
        A obj = new A();

        obj.publicMethod();
        obj.GetterprivateMethod();
        obj.protectedMethod(); // B doesnt extend A so wont work

        // obj.defaultMethod(); // B is not in the same package so wont work

        // obj.privateMethod(); // Not in the same class so wont work
    }
}
