package interfaces;
/**
 * This interface defines the behaviour for the student.
 */

import java.util.List;
import java.util.Map;

public interface Student extends GameObject, Collidable, Moveable {
    /**
     * A method that is getting the intelligence of the object.
     * @return the intelligence of the object.
     */

    int getIntelligence();

    /**
     * This method is used to set intelligence to the object.
     * @param intelligence set intelligence to the object.
     */

    void setIntelligence(int intelligence);

    /**
     * A method that indicates the knowledge of the object.
     * @return an Integer indicating the knowledge of the object.
     */


    int getKnowledge();

    /**
     *  This method is used to set knowledge to the object.
     * @param knowledge set knowledge to the object.
     */
    void setKnowledge(int knowledge);

    /**
     * A method that indicates the vitality of the object.
     * @return an Integer indicating the vitality of the object.
     */

    int getVitality();

    /**
     * This method is used to set vitality to the object.
     * @param vitality set vitality to the object.
     */

    void setVitality(int vitality);

    /**
     * A method that indicates the calculate grade of the object.
     * @return an Integer indicating the calculate grade of the object.
     */


    int calculateGrade();

    /**
     * This method is used to add score to the object.
     * @param grade add grade.
     * @param language add language.
     */

    void addScore(int grade, ProgrammingLanguage language);

    /**
     * This method is used to set stats values to the object.
     * @param grade sets grade.
     * @param language sets language.
     */


    void setStatsValues(int grade, ProgrammingLanguage language);

    /**
     * A method that indicates when the object is exhausted.
     */

    void getExhausted();

    /**
     * A method that gets grades of the student.
     * @return the grades of the student.
     */

    Map<String, List<Integer>> getStudentGrades();

    /**
     *  A method that gets the username of the object.
     * @return String that indicates the username of the object.
     */


    String getUsername();

    /**
     *  A method that gets the full name of the object.
     * @return String that indicates the full name of the object.
     */

    String getFullName();

}

