// Create a University class that has a static variable universityName and a non-static variable
// studentName. Include a static method to display the university name. Then, create multiple
// student objects to demonstrate how the static variable is shared among all instances, while
// the non-static variable holds unique values for each object
class University1 {
    static String universityName = "Super Cool University"; // Static
    String studentName; // Non Static

    public University1(String studentName) {
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
        University1.displayUniversity();

        University1 student1 = new University1("Student 1");
        University1 student2 = new University1("Student 2");

        student1.displayStudent();
        student2.displayStudent();


        System.out.println("----- Changed Name -----");

        University1.universityName = "University 2";

        University1.displayUniversity();

        student1.displayStudent();
        student2.displayStudent();
    }
}
