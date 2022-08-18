public class Course {

    private String name;
    private int durationInDays;

    public Course(String name, int timeInDays) {
        this.name = name;
        this.durationInDays = timeInDays;
    }

    public String getName() {
        return name;
    }

    public int getDurationInDays() {
        return durationInDays;
    }
}