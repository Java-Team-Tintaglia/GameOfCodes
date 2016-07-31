package core;

import interfaces.Wizard;
import models.programmingLanguages.ProgrammingLanguage;
import models.students.Student;
import models.wizards.WizardImpl;

import java.util.List;

public class CollisionHandler {

    public static void handleCollisions(Student student,
                                        Wizard wizard,
                                        List<ProgrammingLanguage> programmingLanguages) {
        if (wizard != null && wizard.isExist() && student.getColliderBox().intersects(wizard.getColliderBox())) {
            wizard.setExist(false);
            wizard.boost(student);
        }

        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
            if (student.getColliderBox().intersects(programmingLanguage.getColliderBox())) {
                if (programmingLanguage.isExist()) {
                    programmingLanguage.setExist(false);
                    int score = student.calculateGrade(programmingLanguage);
                    student.addScore(score, programmingLanguage);
                }
            }
        }
    }
}
