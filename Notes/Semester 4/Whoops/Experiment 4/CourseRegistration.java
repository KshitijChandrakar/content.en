// A student is developing a course registration system that allows students to enroll in
// courses. Each course has a course name and a course code. Implement a Course class with
// appropriate attributes and use the “this” keyword to differentiate between class attributes
// and constructor parameters during initialization. Create an object of the Course class and
// display the course details
class Course{
  public String CourseName;
  public String CourseCode;
  public Course(String CourseName, String CourseCode){
    this.CourseName = CourseName;
    this.CourseCode = CourseCode;
  }
  public void displayDetails(){
    System.out.println("Course Name: " + this.CourseName);
    System.out.println("Course Code: " + this.CourseCode);
  }
}
class CourseRegistration{
  public static void main(String[] args) {
    Course Maths = new Course("Maths", "Math100");
    Course CompSci = new Course("CompSci", "CompSci100");
    Maths.displayDetails();
    CompSci.displayDetails();
  }
}
