package interfaces;

import java.util.List;
import java.util.Map;

public interface Student extends GameObject, Collidable, Moveable {

    int getIntelligence();

    void setIntelligence(int intelligence);

    int getKnowledge();

    void setKnowledge(int knowledge);

    int getVitality();

    void setVitality(int vitality);

    int calculateGrade();

    void addScore(int grade, ProgrammingLanguage language);

    void setStatsValues(int grade, ProgrammingLanguage language);

    void getExhausted();
    
    Map<String, List<Integer>> getStudentGrades();
    
    String getUsername();
    
    String getFullName();

}
