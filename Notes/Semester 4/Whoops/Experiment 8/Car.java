// Create an outer class Car with an inner class Engine. The Engine class should
// have a method
// start() that prints "Engine started" and a method stop() that prints "Engine
// stopped". The Car
// class should have a method drive() that creates an instance of the Engine
// class and calls its
// start() and stop() methods
class Car {
  static void drive() {
    Engine e = new Engine();
    e.Start();
    e.Stop();
  }

  static class Engine {
    void Start() {
      System.out.println("Engine Started");
    }

    void Stop() {
      System.out.println("Engine Stopped");
    }
  }

  public static void main(String[] args) {
    drive();
  }
}
