package interfaces;

import enums.ProgrammingLanguageType;

/**
 * This interface defines the behavior for the programming language.
 */
public interface ProgrammingLanguage extends GameObject, Collidable, Existable {

	/**
	 * A method that indicates the programming language type.
	 * @return  the programming language type.
	 */
	ProgrammingLanguageType getProgrammingLanguageType();

	/**
	 * A method that is used to get the vitality damage points.
	 * @return  the vitality damage points.
	 */
	int getVitalityDamagePoints();

	/**
	 * A method that is used to get the knowledge points
	 * @return the knowledge points.
	 */
	int getKnowledgePoints();
}