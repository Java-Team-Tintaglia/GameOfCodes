package interfaces;

import java.util.List;
import java.util.Map;

/**
 * This interface defines the behavior for a student.
 */
public interface Student extends GameObject, Collidable, Moveable {
    
	/**
     * A method that is getting the intelligence of the student.
     * @return the intelligence of the student.
     */
    int getIntelligence();

    /**
     * This method is used to set intelligence to the student.
     * @param intelligence set intelligence to the student.
     */
    void setIntelligence(int intelligence);

    /**
     * A method that indicates the knowledge of the student.
     * @return an Integer indicating the knowledge of the student.
     */
    int getKnowledge();

    /**
     *  This method is used to set knowledge to the student.
     * @param knowledge set knowledge to the student.
     */
    void setKnowledge(int knowledge);

    /**
     * A method that indicates the vitality of the student.
     * @return an Integer indicating the vitality of the student.
     */

    int getVitality();
    
    /**
     * This method is used to set vitality to the student.
     * @param vitality set vitality to the student.
     */
    void setVitality(int vitality);

    /**
     * A method that calculates the grade of the student.
     * @return an Integer indicating the calculated grade of the student.
     */
    int calculateGrade();

    /**
     * This method is used to add score of the student.
     * @param grade - the score of the student.
     * @param programmingLanguage - gets the ProgrammingLanguage characteristics.
     */
    void addScore(int grade, ProgrammingLanguage programmingLanguage);

    /**
     * This method is used to set stats values to the student.
     * @param grade - the score of the student.
     * @param language - gets the ProgrammingLanguage characteristics and sets students stats depend on them.
     */
    void setStatsValues(int grade, ProgrammingLanguage language);

    /**
     * A method that indicates when the student is exhausted.
     */
    void getExhausted();

    /**
     * A method that gets grades of the student.
     * @return the grades of the student.
     */
    Map<String, List<Integer>> getStudentGrades();

    /**
     *  A method that gets the username of the student.
     * @return String that indicates the username of the student.
     */
    String getUsername();

    /**
     *  A method that gets the full name of the student.
     * @return String that indicates the full name of the student.
     */
    String getFullName();

}

