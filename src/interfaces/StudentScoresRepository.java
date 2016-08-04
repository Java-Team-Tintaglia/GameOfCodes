package interfaces;
/**
 * This interface defines the behaviour for the score of each student.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This interface defines the behavior for a Student's Scores Repository.
 */
public interface StudentScoresRepository {
    
	/**
     * This method is used to save the scores to a file.
     * @param username - the username of the student.
     * @param studentsGrades - the grades of the student which will be saved.
     */
    void saveToFile(String username, Map<String, List<Integer>> studentsGrades);

    /**
     * This method is used to save the scores to a file.
     */
    void readFromFile();

    /**
     * A method that is used to get all grades of one student.
     * @param username - the username of the user.
     * @return all grades of the current student.
     */
    Map<String, ArrayList<Integer>> getAllGradesBySubject(String username);
}

