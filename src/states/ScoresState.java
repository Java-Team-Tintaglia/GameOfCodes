package states;

import graphics.Assets;
import models.Button;
import repositories.StudentScoresRepository;
import utils.Constants;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static repositories.StudentScoresRepository.students;

public class ScoresState extends State {

	public static Button backToMenuButton = new Button(730, 500, Assets.buttonBackToMenu);
	
    @Override
    public void draw(Graphics graphics) {
        int yCoord = 125;
        StudentScoresRepository.readFromFile();

        graphics.drawImage(Assets.highScoresBackground, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);

        Font font = new Font("Arial", Font.ITALIC, 25);
        graphics.setFont(font);
        graphics.setColor(Color.white);

        for(Map.Entry<String, LinkedHashMap<String, List<Integer>>> student : students.entrySet()){
            String name = student.getKey();
            LinkedHashMap<String, List<Integer>> scores = student.getValue();
            float averageScore = 0;
            for(Map.Entry<String, List<Integer>> score : scores.entrySet()){
                for(int sc : score.getValue()){
                    averageScore += sc;
                }
                averageScore /= score.getValue().size();
            }

            graphics.drawString(name, 120, yCoord);
            graphics.drawString(String.format("%.2f", averageScore), 540, yCoord);
            yCoord += 40;
        }
        
        backToMenuButton.draw(graphics);
    }

    @Override
    public void update() {

    }
}
