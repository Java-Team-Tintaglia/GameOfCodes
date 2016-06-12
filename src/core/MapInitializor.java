package core;

import models.programmingLanguages.*;
import utils.RandomGenerator;

public class MapInitializor {

    public static ProgrammingLanguage generateProgrammingLanguage(){
        String[] programmingLanguages = {"CPlusPlus", "CSharp", "Java", "JavaScript", "Php"};
        int randomIndex = RandomGenerator.getNextRandom(programmingLanguages.length);
        String randomLanguage = programmingLanguages[randomIndex];
        int randomX = RandomGenerator.getNextRandom(800);
        int randomY = RandomGenerator.getNextRandom(300);

        ProgrammingLanguage langToBeCreated = null;

        switch (randomLanguage){
            case "CPlusPlus":
                langToBeCreated = new CPlusPlus(randomX, randomY);
                break;
            case "CSharp":
                langToBeCreated = new CSharp(randomX, randomY);
                break;
            case "Java":
                langToBeCreated = new Java(randomX, randomY);
                break;
            case "JavaScript":
                langToBeCreated = new JavaScript(randomX, randomY);
                break;
            case "Php":
                langToBeCreated = new Php(randomX, randomY);
                break;
        }
        return langToBeCreated;
    }



}
