package core;

import java.util.List;

import models.programmingLanguages.ProgrammingLanguage;
import models.students.Student;
import models.wizards.Wizard;

public class CollisionHandler {

    public static void handleCollisions(Student student,
                                        Wizard wizard,
                                        List<ProgrammingLanguage> programmingLanguages) {
    	
        if (student.getColliderBox().intersects(wizard.getColliderBox())) {
            wizard.setExist(false);
            wizard.boost(student);
        }

        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
            if (student.getColliderBox().intersects(programmingLanguage.getColliderBox())) {
                programmingLanguage.setExist(false);
                int score = student.calculateGrade(programmingLanguage);
                System.out.println(score);
                student.addScore(score, programmingLanguage);
            }
        }
    }
}
