package interfaces;

import enums.WizardType;

/**
 * This interface defines a wizard.
 */
public interface Wizard extends GameObject, Collidable, Existable {
	
	/**
	 * This method gets the type of a wizard.
	 * @return WizardType
	 */
    WizardType getWizardType();

    /**
     * This method boosts student's abilities.
     * @param student - the student that will be boosted.
     */
    void boost(Student student);

}
