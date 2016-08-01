package enums;

public enum WizardType {
    VITALITY_WIZARD("models.wizards.VitalityWizard"),
    KNOWLEDGE_WIZARD("models.wizards.KnowledgeWizard"),
    INTELLIGENCE_WIZARD("models.wizards.IntelligenceWizard");

    private String className;

    WizardType(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }
}
