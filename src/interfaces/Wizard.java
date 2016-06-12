package interfaces;

import enums.WizardType;
import models.students.Student;

public interface Wizard {
    void boost(Student student);
    WizardType getType();

}
