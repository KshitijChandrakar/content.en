// Create an interface EventHandler with a method handleEvent(). In the main
// method, demonstrate the use of:
// a. A local inner class inside a method registerEvent() that implements
// EventHandler and prints "Event handled by local inner class".
// b. An anonymous inner class that implements EventHandler and prints "Event
// handled by anonymous inner class".

interface EventHandler {
  public void handleEvent();

}

class Event {

  public static void registerEvent() {
    class LocalInner implements EventHandler {
      @Override
      public void handleEvent() {
        System.out.println("Handled by Local Inner Class");
      }
    }
    LocalInner l = new LocalInner();
    l.handleEvent();
  }

  public static void main(String[] args) {
    // A
    registerEvent();
    // B
    EventHandler anonymousHandler = new EventHandler() {
      @Override
      public void handleEvent() {
        System.out.println("Event handled by anonymous inner class");
      }
    };
    anonymousHandler.handleEvent();
  }
}
