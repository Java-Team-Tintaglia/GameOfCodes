package interfaces;


import enums.ProgrammingLanguageType;

public interface ProgrammingLanguage extends GameObject, Collidable, Existable {


	/*
	* <summary>
	*     A method that indicates the programing language type
	* </summary>
	* <returns>
	* 	Returns the programing language type.
	* </returns>
	* */
	ProgrammingLanguageType getProgrammingLanguageType();

	/*
* <summary>
* </summary>
* <returns>
* 	Returns the vitality damage points.
* </returns>
* */
	int getVitalityDamagePoints();

	/*
	* <summary>
	* </summary>
	* <returns>
	* 	Returns the knowledge points.
	* </returns>
	* */
	int getKnowledgePoints();
}