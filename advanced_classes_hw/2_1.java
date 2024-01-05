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
}
