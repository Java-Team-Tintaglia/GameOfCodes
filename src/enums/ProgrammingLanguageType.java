package enums;

public enum  ProgrammingLanguageType {
    JAVA("Java"),
    C_SHARP("C#"),
    PHP("PHP"),
    JAVA_SCRIPT("JavaScript"),
    C_PLUS_PLUS("C++");

    private String name;

    ProgrammingLanguageType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


