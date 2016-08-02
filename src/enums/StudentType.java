package enums;

public enum StudentType {
    NERD_LADY("NerdLady"),
    NERD_BOY("NerdBoy"),
    HOT_CHICK("HotChick"),
    BAD_BOY("BadBoy");

    private String className;

    StudentType(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }
}
