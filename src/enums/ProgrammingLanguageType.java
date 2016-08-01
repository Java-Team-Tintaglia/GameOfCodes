package enums;

public enum  ProgrammingLanguageType {
    JAVA("Java", "models.programmingLanguages.Java"),
    C_SHARP("C#", "models.programmingLanguages.CSharp"),
    PHP("PHP", "models.programmingLanguages.Php"),
    JAVA_SCRIPT("JavaScript", "models.programmingLanguages.JavaScript"),
    C_PLUS_PLUS("C++", "models.programmingLanguages.CPlusPlus");

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


