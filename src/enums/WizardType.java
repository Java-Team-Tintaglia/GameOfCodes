package enums;

public enum WizardType {
    VITALITY_WIZARD("VitalityWizard"),
    KNOWLEDGE_WIZARD("KnowledgeWizard"),
    INTELLIGENCE_WIZARD("IntelligenceWizard");

    private String className;

    WizardType(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }
}
