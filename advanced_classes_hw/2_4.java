class Athlete {
    private int age;
    private String name;
    private String yearInSchool;

    public Athlete() {
        age = 15;
        name = "SallyJoeBob";
        yearInSchool = "Sophomore";
    }

    public Athlete(int age, String name, String yearInSchool) {
        this.age = age;
        this.name = name;
        this.yearInSchool = yearInSchool;
    }

    protected int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Year in School: " + yearInSchool;
    }
}

class Runner extends Athlete implements Comparable<Runner> {
    private String typeOfRunner;

    private int runnerLevel;

    public Runner() {
        super(18, "JohnDoe", "Junior");
        typeOfRunner = "Sprinter";
        runnerLevel = 5;
    }

    public Runner(int age, String name, String yearInSchool, String typeOfRunner, int runnerLevel) {
        super(age, name, yearInSchool);
        this.typeOfRunner = typeOfRunner;
        this.runnerLevel = runnerLevel;
    }

    public int getRunnerLevel() {
        return runnerLevel;
    }

    @Override
    public String toString() {
        return super.toString() + ", Type of Runner: " + typeOfRunner;
    }

    @Override
    public int compareTo(Runner otherRunner) {
        return Integer.compare(this.runnerLevel, otherRunner.runnerLevel);
    }
}
