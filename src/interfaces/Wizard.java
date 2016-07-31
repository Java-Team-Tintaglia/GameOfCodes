package interfaces;

import enums.WizardType;

public interface Wizard extends GameObject, Collidable {
	
    boolean isExist();

    void setExist(boolean exist);

    WizardType getWizardType();

    void boost(Student student);

}
