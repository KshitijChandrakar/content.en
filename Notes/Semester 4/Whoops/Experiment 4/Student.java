// Create a Student class with attributes for name and age. Implement a default constructor to
// assign default values and a parameterized constructor to initialize the attributes with user-
// defined values. Create objects using both constructors and display their details.
class Student1 {
    String Name;
    int Age;
    Student1(String  Name, int Age){
      this.Name = Name;
      this.Age = Age;
      System.out.print("Name: " + this.Name + "\n" + ("Age: " + this.Age + "\n"));
    }
    Student1(){
      this.Name = "Default Name";
      this.Age = 0;
      System.out.print("Name: " + this.Name + "\n" + ("Age: " + this.Age + "\n"));
    }
}
public class Student{
  public static void main(String[] args) {
    System.out.println("Default Student");
    Student1 DefaultStudent1 = new Student1();
    System.out.println("Named Student");
    Student1 NamedStudent1 = new Student1("Named Student1", 12);

  }
}
