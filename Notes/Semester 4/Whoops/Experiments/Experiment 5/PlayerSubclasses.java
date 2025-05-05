class Player {
    protected String name;
    protected int age;
    protected String position;

    public Player(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public void play() {
        System.out.println(name + " is playing as a " + position);
    }

    public void train() {
        System.out.println("training" + name);
    }
}

class Cricket_Player extends Player {
    public Cricket_Player(String name, int age, String position) {
        super(name, age, position);
    }

    @Override
    public void play() {
        System.out.println(name + " is playing cricket as a " + position);
    }

    @Override
    public void train() {
        System.out.println(name + " is practicing cricket.");
    }
}

class Football_Player extends Player {
    public Football_Player(String name, int age, String position) {
        super(name, age, position);
    }

    @Override
    public void play() {
        System.out.println(name + " is playing football as a " + position);
    }

    @Override
    public void train() {
        System.out.println(name + " is practicing football.");
    }
}

class Hockey_Player extends Player {
    public Hockey_Player(String name, int age, String position) {
        super(name, age, position);
    }

    @Override
    public void play() {
        System.out.println(name + " is playing hockey as a " + position);
    }

    @Override
    public void train() {
        System.out.println(name + " is practicing Hockey.");
    }
}

public class PlayerSubclasses {
  public static void main(String[] args) {
        Cricket_Player cricketer = new Cricket_Player("Virat Kohli", 35, "Batsman");
        Football_Player footballer = new Football_Player("Lionel Messi", 37, "Forward");
        Hockey_Player hockeyPlayer = new Hockey_Player("Manpreet Singh", 32, "Midfielder");

        System.out.println("Cricket Player");
        cricketer.play();
        cricketer.train();

        System.out.println("Football Player");
        footballer.play();
        footballer.train();

        System.out.println("Hockey Player");
        hockeyPlayer.play();
        hockeyPlayer.train();

    }
}
