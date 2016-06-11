package interfaces;

import models.students.Student;

public interface Wizard {
    public enum WizardType {
        VITALITY, KNOWLEDGE, INTELLIGENCE
    }

    void boost(Student student);
    WizardType getType();
}
