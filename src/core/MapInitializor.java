package core;

import enums.ProgrammingLanguageType;
import models.programmingLanguages.*;
import utils.RandomGenerator;

public class MapInitializor {

    public static ProgrammingLanguage generateProgrammingLanguage(){
        ProgrammingLanguageType[] programmingLanguages = {
        		ProgrammingLanguageType.JAVA,
        		ProgrammingLanguageType.C_PLUS_PLUS, 
        		ProgrammingLanguageType.C_SHARP,
        		ProgrammingLanguageType.PHP,
        		ProgrammingLanguageType.JAVA_SCRIPT};
        
        int randomIndex = RandomGenerator.getNextRandom(programmingLanguages.length);
        
        ProgrammingLanguageType randomLanguage = programmingLanguages[randomIndex];
        
        int randomX = RandomGenerator.getNextRandom(800);
        int randomY = RandomGenerator.getNextRandom(300);

        ProgrammingLanguage langToBeCreated = null;

        switch (randomLanguage){
            case C_PLUS_PLUS:
                langToBeCreated = new CPlusPlus(randomX, randomY);
                break;
            case C_SHARP:
                langToBeCreated = new CSharp(randomX, randomY);
                break;
            case JAVA:
                langToBeCreated = new Java(randomX, randomY);
                break;
            case JAVA_SCRIPT:
                langToBeCreated = new JavaScript(randomX, randomY);
                break;
            case PHP:
                langToBeCreated = new Php(randomX, randomY);
                break;
        }
        return langToBeCreated;
    }



}
