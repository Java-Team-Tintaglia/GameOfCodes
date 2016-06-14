package core;

import java.util.List;

import models.programmingLanguages.ProgrammingLanguage;
import models.students.Student;
import models.wizards.Wizard;

public class CollisionHandler {

    public static void collisionHandler(Student student,
                                        Wizard wizard,
                                        List<ProgrammingLanguage> programmingLanguages) {
        if (student.getColliderBox().intersects(wizard.getColliderBox()) ||
                wizard.getColliderBox().intersects(student.getColliderBox())) {
            wizard.setExist(false);

        }
        //gledash setvam tuka eto
        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
            if (student.getColliderBox().intersects(programmingLanguage.getColliderBox())) {
                programmingLanguage.setExist(false);
                programmingLanguage.setKnowledgePoints(programmingLanguage.getKnowledgePoints());
                student.calculateGrade(programmingLanguage);

                student.setVitality(programmingLanguage.getVitalityDamagePoints());
                //student.setIntelligence(programmingLanguage.in());

            }
        }


    }


}
