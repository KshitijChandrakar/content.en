// Create a Student class that has a static variable universityName and a non-static variable
// studentName. Include a static method to display the university name. Then, create multiple
// student objects to demonstrate how the static variable is shared among all instances, while
// the non-static variable holds unique values for each object
class Student {
    static String universityName = "Super Cool University"; // Static
    String studentName; // Non Static

    public Student(String studentName) {
        this.studentName = studentName;
    }

    static void displayUniversity() {
        System.out.println("University: " + universityName);
    }

    void displayStudent() {
        System.out.println("Student: " + studentName + "\nUniversity: " + universityName);
    }
}

public class University {
    public static void main(String[] args) {

        System.out.println("----- Initial Name -----");
        Student.displayUniversity();

        Student student1 = new Student("Student 1");
        Student student2 = new Student("Student 2");

        student1.displayStudent();
        student2.displayStudent();


        System.out.println("----- Changed Name -----");

        Student.universityName = "University 2";

        Student.displayUniversity();

        student1.displayStudent();
        student2.displayStudent();
    }
}
