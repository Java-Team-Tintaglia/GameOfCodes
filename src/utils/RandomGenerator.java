package utils;

import java.util.Random;

public class RandomGenerator {

    private static Random random;

    public static int getNextRandom(int maxValue)
    {
        if (random == null) {
            init();
        }
        
        return random.nextInt(maxValue);
    }
    
    public static int genNextRandomMinMax(int minValue, int maxValue) {
        if (random == null){
            init();
        }
        
        return random.nextInt(maxValue - minValue) + minValue;
    }
    
    private static void init() {
        random = new Random();
    }
}
