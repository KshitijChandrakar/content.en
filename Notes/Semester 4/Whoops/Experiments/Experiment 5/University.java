class Person {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }
}


class Staff extends Person {
    private String staffId;
    private String department;

    public Staff(String name, int age, String address, String staffId, String department) {
        super(name, age, address);
        this.staffId = staffId;
        this.department = department;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Staff ID: " + staffId);
        System.out.println("Department: " + department);
    }
}

class Professor extends Staff {
    private String specialization;

    public Professor(String name, int age, String address, String staffId, String department, String specialization) {
        super(name, age, address, staffId, department);
        this.specialization = specialization;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Specialization: " + specialization);
    }

    public void conductLecture() {
        System.out.println("Professor " + getName() + " is conducting a lecture on " + specialization + ".");
    }

    private String getName() {
        return "Professor";
    }
}

class Student extends Person {
    private String studentId;
    private String course;

    public Student(String name, int age, String address, String studentId, String course) {
        super(name, age, address);
        this.studentId = studentId;
        this.course = course;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
    }
}

class GraduateStudent extends Student {
    private String researchTopic;

    public GraduateStudent(String name, int age, String address, String studentId, String course, String researchTopic) {
        super(name, age, address, studentId, course);
        this.researchTopic = researchTopic;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Research Topic: " + researchTopic);
    }

    public void submitThesis() {
        System.out.println("Graduate student " + getName() + " has submitted their thesis on " + researchTopic + ".");
    }

    private String getName() {
        return "Graduate Student";
    }
}

public class University{
    public static void main(String[] args) {
        Professor professor = new Professor("Dr. Doctor", 45, "Some Address", "S123", "Computer Science", "Artificial Intelligence");

        GraduateStudent gradStudent = new GraduateStudent("Graduate Idiot", 25, "Somewhereeeee", "S456", "MSc Computer Science", "Machine Learning");

        Person[] people = new Person[2];
        people[0] = professor;
        people[1] = gradStudent;

        for (Person person : people) {
            person.displayDetails();
            System.out.println();

            if (person instanceof Professor) {
                ((Professor) person).conductLecture();
            } else if (person instanceof GraduateStudent) {
                ((GraduateStudent) person).submitThesis();
            }
            System.out.println("--------------------------");
        }
    }
}
