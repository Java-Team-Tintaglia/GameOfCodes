package enums;

public enum  ProgrammingLanguageType {
    JAVA("Java", "Java"),
    C_SHARP("C#", "CSharp"),
    PHP("PHP", "Php"),
    JAVA_SCRIPT("JavaScript", "JavaScript"),
    C_PLUS_PLUS("C++", "CPlusPlus");

    private String name;
    private String className;

    ProgrammingLanguageType(String name, String className) {
        this.name = name;
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }

    public String getName() {
        return name;
    }
}


