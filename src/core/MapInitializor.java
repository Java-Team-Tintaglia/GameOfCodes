package core;

import constants.Common;
import constants.Messages;
import enums.ProgrammingLanguageType;
import enums.WizardType;
import interfaces.ProgrammingLanguage;
import interfaces.Wizard;
import utils.RandomGenerator;

import java.lang.reflect.Constructor;

public class MapInitializor {

	private static final int MAX_X_COORD = 950;
	private static final int MIN_Y_COORD = 235;
	private static final int MAX_Y_COORD = 515;

    public static ProgrammingLanguage generateProgrammingLanguage() {
        ProgrammingLanguageType[] programmingLanguages = ProgrammingLanguageType.values();
        
        int randomIndex = RandomGenerator.getNextRandom(programmingLanguages.length);
        int randomX = RandomGenerator.getNextRandom(0, MAX_X_COORD);
        int randomY = RandomGenerator.getNextRandom(MIN_Y_COORD, MAX_Y_COORD);

        ProgrammingLanguageType randomLanguage = programmingLanguages[randomIndex];
        String className = Common.PROGRAMMING_LANGUAGES_PACKAGE + randomLanguage.getClassName();

        ProgrammingLanguage generatedProgrammingLanguage = createObject(randomX, randomY, className);
        return generatedProgrammingLanguage;
    }

    public static Wizard generateWizard() {
        WizardType[] wizards = WizardType.values();
        
        int randomIndex = RandomGenerator.getNextRandom(wizards.length);
        int randomX = RandomGenerator.getNextRandom(0, MAX_X_COORD);
        int randomY = RandomGenerator.getNextRandom(MIN_Y_COORD, MAX_Y_COORD);

        WizardType randomWizard = wizards[randomIndex];
        String className = Common.WIZARDS_PACKAGE + randomWizard.getClassName();

        Wizard generatedWizard = createObject(randomX, randomY, className);
        return generatedWizard;
    }

    private static <T> T createObject(int randomX, int randomY, String className) {
        T objectToBeCreated = null;
        try {
            Class<T> classInfo = (Class<T>) Class.forName(className);
            Constructor<T> ctor = classInfo.getConstructor(int.class, int.class);
            objectToBeCreated = ctor.newInstance(randomX, randomY);
        } catch (ReflectiveOperationException roe) {
            String message = String.format(Messages.OBJECT_CREATION_FAILURE, className);
            System.err.println(message);
        }

        return objectToBeCreated;
    }
}
