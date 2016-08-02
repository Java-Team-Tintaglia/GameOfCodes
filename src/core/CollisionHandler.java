package core;

import interfaces.ProgrammingLanguage;
import interfaces.Student;
import interfaces.Wizard;

import java.util.List;

public class CollisionHandler {

    public static void handleCollisions(Student student,
                                        Wizard wizard,
                                        List<ProgrammingLanguage> programmingLanguages) {
        if (wizard != null && wizard.isExist() 
        		&& student.getCollideBox().intersects(wizard.getCollideBox())) {
            wizard.setExist(false);
            wizard.boost(student);
        }

        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
            if (student.getCollideBox().intersects(programmingLanguage.getCollideBox())) {
                if (programmingLanguage.isExist()) {
                	programmingLanguage.setExist(false);
                    int score = student.calculateGrade(programmingLanguage);
                    student.addScore(score, programmingLanguage);
                }
            }
        }
    }
}
