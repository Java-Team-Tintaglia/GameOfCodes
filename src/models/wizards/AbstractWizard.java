package models.wizards;

import enums.WizardType;
import interfaces.Wizard;

public abstract class AbstractWizard implements Wizard {
	
    private WizardType wizardType;

    public AbstractWizard(WizardType wizardType) {
        this.wizardType = wizardType;
    }

    @Override
    public WizardType getType() {
        return wizardType;
    }
}
