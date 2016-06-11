package interfaces;

import enums.WizardTypes;
import models.students.Student;

public interface Wizard {
    void boost(Student student);
    WizardTypes getType();

}
