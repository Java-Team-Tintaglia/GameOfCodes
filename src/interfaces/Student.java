package interfaces;
/*
* <summary>
* 	This interface defines the behaviour for the student.
* </summary>
* */

import java.util.List;
import java.util.Map;

public interface Student extends GameObject, Collidable, Moveable {

    int getIntelligence();
    /*
	* <summary>
	*     This method is used to set intelligence to the Student.
	* </summary>
	* <parameters>
	* 	<param type='int'>intelligence</param>
	* </parameters>
	* */

    void setIntelligence(int intelligence);
    /*
	* <summary>
	*     A method that indicates the knowledge of the object.
	* </summary>
	* <returns>
	* 	Returns an Integer indicating the knowledge of the object.
	* </returns>
	* */

    int getKnowledge();
    /*
	* <summary>
	*     This method is used to set knowledge to the object.
	* </summary>
	* <parameters>
	* 	<param type='int'>knowledge</param>
	* </parameters>
	* */
    void setKnowledge(int knowledge);

 /*
	* <summary>
	*     A method that indicates the vitality of the object.
	* </summary>
	* <returns>
	* 	Returns an Integer indicating the vitality of the object.
	* </returns>
	* */

    int getVitality();

      /*
	* <summary>
	*     This method is used to set vitality to the object.
	* </summary>
	* <parameters>
	* 	<param type='int'>vitality</param>
	* </parameters>
	* */

    void setVitality(int vitality);
 /*
	* <summary>
	*     A method that indicates the calculate grade of the object.
	* </summary>
	* <returns>
	* 	Returns an Integer indicating the calculate grade of the object.
	* </returns>
	* */

    int calculateGrade();

      /*
	* <summary>
	*     This method is used to add score to the object.
	* </summary>
	* <parameters>
	* 	<param type='int'>grade</param>
	* </parameters>
	* */

    void addScore(int grade, ProgrammingLanguage language); // ???
      /*
	* <summary>
	*       This method is used to set stats values to the object.
	* </summary>
	* <parameters>
	* 	<param type='int'>grade</param>
	* </parameters>
	* */


    void setStatsValues(int grade, ProgrammingLanguage language);

    /*
    * <summary>
    *     A method that indicates when the object is exhausted.
    * </summary>
    * <returns>
    * 	Indicates when the object is exhausted.
    * </returns>
    * */
    void getExhausted();

    Map<String, List<Integer>> getStudentGrades();

    /*
  * <summary>
  *     A method that gets the username of the object.
  * </summary>
  * <returns>
  * 	Returns String that indicates the username of the object.
  * </returns>
  * */
    String getUsername();
    /*
  * <summary>
  *     A method that gets the full name of the object.
  * </summary>
  * <returns>
  * 	Returns String that indicates the full name of the object.
  * </returns>
  * */
    String getFullName();

}

