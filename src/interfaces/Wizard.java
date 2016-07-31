package interfaces;

import enums.WizardType;

public interface Wizard extends GameObject, Collidable, Existable {
	
    WizardType getWizardType();

    void boost(Student student);

}
