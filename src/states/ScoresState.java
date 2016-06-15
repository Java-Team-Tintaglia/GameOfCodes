package states;

import graphics.Assets;
import models.Button;
import repositories.StudentScoresRepository;
import utils.Constants;

import java.awt.*;
import java.util.*;
import java.util.List;

public class ScoresState extends State {

	public static Button backToMenuButton = new Button(730, 500, Assets.buttonBackToMenu);
	
    @Override
    public void draw(Graphics graphics) {
        int yCoord = 125;
        StudentScoresRepository.readFromFile();

        graphics.drawImage(Assets.highScoresBackground, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);

        Font font = new Font("Consolas", Font.PLAIN, 25);
        graphics.setFont(font);
        graphics.setColor(Color.white);

        graphics.drawString("Player name", 160, yCoord);
        graphics.drawString("Average grade", 540, yCoord);

        TreeMap<Float, String> topScores = new TreeMap<>(Collections.reverseOrder());
        for(Map.Entry<String, LinkedHashMap<String, List<Integer>>> student : StudentScoresRepository.studentsScore.entrySet()){
            String name = student.getKey();
            LinkedHashMap<String, List<Integer>> scores = student.getValue();
            float averageScore = 0f;
            for(Map.Entry<String, List<Integer>> score : scores.entrySet()){
                for(int sc : score.getValue()){
                    averageScore += sc;
                }
                averageScore /= score.getValue().size();
            }

            topScores.put(averageScore, name);
        }

        //TODO: Fix the ordering of the scores
        int counter = 1;
        for(Map.Entry<Float, String> score : topScores.entrySet()){
            yCoord += 40;
            graphics.drawString(String.format("%d", counter), 120, yCoord);
            graphics.drawString(score.getValue(), 160, yCoord);
            graphics.drawString(String.format("%.2f", score.getKey()), 560, yCoord);
            counter++;
            if(counter == 10){
                break;
            }
        }
        
        backToMenuButton.draw(graphics);
    }

    @Override
    public void update() {

    }
}
