package core;

import enums.ProgrammingLanguageType;
import enums.WizardType;
import interfaces.ProgrammingLanguage;
import interfaces.Wizard;
import models.programmingLanguages.*;
import models.wizards.IntelligenceWizard;
import models.wizards.KnowledgeWizard;
import models.wizards.VitalityWizard;
import utils.RandomGenerator;

public class MapInitializor {
	private static final int MAX_X_COORD = 950;
	private static final int MIN_Y_COORD = 235;
	private static final int MAX_Y_COORD = 515;

    public static ProgrammingLanguage generateProgrammingLanguage() {
        ProgrammingLanguageType[] programmingLanguages = {
        		ProgrammingLanguageType.JAVA,
        		ProgrammingLanguageType.C_PLUS_PLUS, 
        		ProgrammingLanguageType.C_SHARP,
        		ProgrammingLanguageType.PHP,
        		ProgrammingLanguageType.JAVA_SCRIPT};
        
        int randomIndex = RandomGenerator.getNextRandom(programmingLanguages.length);
        
        ProgrammingLanguageType randomLanguage = programmingLanguages[randomIndex];

        int randomX = RandomGenerator.getNextRandom(0, MAX_X_COORD);
        int randomY = RandomGenerator.getNextRandom(MIN_Y_COORD, MAX_Y_COORD);

        ProgrammingLanguage languageToBeCreated = null;

        switch (randomLanguage) {
            case C_PLUS_PLUS:
                languageToBeCreated = new CPlusPlus(randomX, randomY);
                break;
            case C_SHARP:
                languageToBeCreated = new CSharp(randomX, randomY);
                break;
            case JAVA:
                languageToBeCreated = new Java(randomX, randomY);
                break;
            case JAVA_SCRIPT:
                languageToBeCreated = new JavaScript(randomX, randomY);
                break;
            case PHP:
                languageToBeCreated = new Php(randomX, randomY);
                break;

        }
        
        return languageToBeCreated;
    }

    public static Wizard generateWizard() {
        WizardType[] wizard = {
        		WizardType.INTELLIGENCE_WIZARD, 
        		WizardType.KNOWLEDGE_WIZARD, 
        		WizardType.VITALITY_WIZARD};
        
        int randomIndex = RandomGenerator.getNextRandom(wizard.length);
        WizardType randomWizard = wizard[randomIndex];

        int randomX = RandomGenerator.getNextRandom(0, MAX_X_COORD);
        int randomY = RandomGenerator.getNextRandom(MIN_Y_COORD, MAX_Y_COORD);

        Wizard wizardToBeCreated = null;

        switch (randomWizard) {
            case INTELLIGENCE_WIZARD:
                wizardToBeCreated = new IntelligenceWizard(randomX,randomY);
                break;
            case KNOWLEDGE_WIZARD:
                wizardToBeCreated = new KnowledgeWizard(randomX, randomY);
                break;
            case VITALITY_WIZARD:
                wizardToBeCreated = new VitalityWizard(randomX, randomY);
                break;

        }

        return wizardToBeCreated;
    }
}
