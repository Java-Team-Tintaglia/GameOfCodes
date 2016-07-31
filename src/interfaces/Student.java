package interfaces;

import models.programmingLanguages.ProgrammingLanguage;

import java.util.List;
import java.util.Map;

/**
 * Created by PetyoPetrov on 31.07.2016 г..
 */
public interface Student extends Collidable, Moveable,Drawable,Updatable {
    String getUsername();

    Map<String, List<Integer>> getStudentGrades();

    int getIntelligence();

    void setIntelligence(int intelligence);

    public int getKnowledge();

    public void setKnowledge(int knowledge);

    public int getVitality();

    public void setVitality(int vitality);

    public int calculateGrade(ProgrammingLanguage language);

    public void addScore(int grade, ProgrammingLanguage language);

    public void getExhausted();

}
