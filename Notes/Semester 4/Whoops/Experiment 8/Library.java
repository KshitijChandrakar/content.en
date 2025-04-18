// Create an outer class Library with a static nested class Book. The Book class should have
// attributes like title, author, and ISBN, and a method displayDetails() to print these details. In
// the main method, create an instance of the Book class and call displayDetails() to show the
// book information.
class Library {
  static class Book {
    String Author;
    String Title;
    String ISBN;

    Book(String Author, String Title, String ISBN) {
      this.Author = Author;
      this.Title = Title;
      this.ISBN = ISBN;
    }

    public void displayDetails() {
      System.out.println("Author: " + Author + "\nTitle: " + Title + "\nISBN: " + ISBN);
    }
  }

  public static void main(String[] args) {
    Book b = new Book("John \"Existential Crisis\" Green", "Turtles All the Way Down", "978-0525555360");
    b.displayDetails();
  }
}
