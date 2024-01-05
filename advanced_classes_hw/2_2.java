class Runner extends Athlete implements Comparable<Runner> {
    private String typeOfRunner;

    private int runnerLevel;

    public Runner() {
        super(18, "JohnDoe", "Junior");
        typeOfRunner = "Sprinter";
        runnerLevel = 5; // default
    }

    public Runner(int age, String name, String yearInSchool) {
        super(age, name, yearInSchool);
        this.typeOfRunner = typeOfRunner;
        this.runnerLevel = runnerLevel;
    }

    public int getRunnerLevel() {
        return runnerLevel;
    }

    @Override
    public int compareTo(Runner otherRunner) {
        return Integer.compare(this.runnerLevel, otherRunner.runnerLevel);
    }
}