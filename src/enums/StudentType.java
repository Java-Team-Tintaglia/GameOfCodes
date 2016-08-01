package enums;

public enum StudentType {
    NERD_LADY("models.students.NerdLady"),
    NERD_BOY("models.students.NerdBoy"),
    HOT_CHICK("models.students.HotChick"),
    BAD_BOY("models.students.BadBoy");

    private String className;

    StudentType(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }
}
