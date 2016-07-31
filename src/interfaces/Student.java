package interfaces;

import models.programmingLanguages.ProgrammingLanguage;

import java.util.List;
import java.util.Map;

public interface Student extends Collidable, Moveable, Drawable, Updatable {
    
	String getUsername();

    Map<String, List<Integer>> getStudentGrades();

    int getIntelligence();

    void setIntelligence(int intelligence);

    int getKnowledge();

    void setKnowledge(int knowledge);

    int getVitality();

    void setVitality(int vitality);

    int calculateGrade(ProgrammingLanguage language);

    void addScore(int grade, ProgrammingLanguage language);

    void getExhausted();

}
