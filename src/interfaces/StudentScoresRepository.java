package interfaces;
/**
 * This interface defines the behaviour for the score of each student.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface StudentScoresRepository {
    /**
     * This method is used to save the scores to files.
     * @param studentName the name of the current student.
     * @param studentsGrades the grades of the current student.
     */
    void saveToFile(String studentName, Map<String, List<Integer>> studentsGrades);


    /**
     * This method is used to save the scores to files.
     */
    void readFromFile();

    /**
     * A method that is used to get all grades of one student.
     * @param username the name of the user.
     * @return all grades of one student.
     */
    Map<String, ArrayList<Integer>> getAllGradesBySubject(String username);
}

