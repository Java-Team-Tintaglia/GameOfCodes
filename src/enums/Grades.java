package enums;

public enum Grades {
    EXCELLENT(6, 91, 100, 1.0),
    VERY_GOOD(5, 76, 90, 0.8),
    GOOD(4, 61, 75, 0.6),
    PASSABLE(3, 51, 60, 0.3),
    FAILURE(2, 0, 50, 0);

    private int grade;
    private int minRate;
    private int maxRate;
    private double factor;

    Grades(int grade, int minRate, int maxRate, double factor) {
        this.grade = grade;
        this.minRate = minRate;
        this.maxRate = maxRate;
        this.factor = factor;
    }

    public int getGrade() {
        return this.grade;
    }

    public int getMinRate() {
        return this.minRate;
    }

    public int getMaxRate() {
        return this.maxRate;
    }

    public double getFactor() {
        return this.factor;
    }
}
