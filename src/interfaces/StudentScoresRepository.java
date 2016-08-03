package interfaces;
/*
* <summary>
* 	This interface defines the behaviour for the score of each student.
* </summary>
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface StudentScoresRepository {
    /*
	* <summary>
	*     This method is used to save the scores to files.
	* </summary>
	* <parameters>
	* 	<param type='String'>studentName</param>
	* 	<param type='Map<String, List<Integer>'>studentsGrades</param>
	* </parameters>
	* */
    void saveToFile(String studentName, Map<String, List<Integer>> studentsGrades);





    /*
   * <summary>
   *     This method is used to save the scores to files.
   * </summary>
   * <parameters>
   * 	<param type='String'>username</param>
   * </parameters>
   * */
    void readFromFile();
    Map<String, ArrayList<Integer>> getAllGradesBySubject(String username); // ???
}

