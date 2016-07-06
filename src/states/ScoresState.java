package states;

import graphics.Assets;
import models.Button;
import repositories.StudentScoresRepository;
import utils.Constants;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ScoresState extends State {

	public static Button backToMenuButton = new Button(730, 500, Assets.buttonBackToMenu);	

	private StudentScoresRepository studentScoresRepository;

    public ScoresState(StudentScoresRepository studentScoresRepository) {
    	this.studentScoresRepository = studentScoresRepository;
    	this.studentScoresRepository.readFromFile();
    }
	    
	@Override
    public void draw(Graphics graphics) {
        int yCoord = 125;
        
        Map<String, List<Integer>> sorted = StudentScoresRepository.studentsScore.entrySet()
				.stream()
				.sorted((a, b) -> Double.compare((double)b.getValue().stream().mapToInt(Integer::intValue).sum() / b.getValue().size(),
						(double)a.getValue().stream().mapToInt(Integer::intValue).sum() / a.getValue().size()))
				.limit(10)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));
        
        graphics.drawImage(Assets.highScoresBackground, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);

        Font font = new Font("Consolas", Font.PLAIN, 25);
        graphics.setFont(font);
        graphics.setColor(Color.white);
        graphics.drawString("Player name", 160, yCoord);
        graphics.drawString("Average grade", 520, yCoord);
   
        int counter = 1;
        for(Entry<String, List<Integer>> entry : sorted.entrySet()){
            String name = entry.getKey();
            
            double totalGrades = (double)entry.getValue().stream().mapToInt(Integer::intValue).sum();
            double totalAmountOfGrades = (double)entry.getValue().size();
        	double averageGrade = totalGrades / totalAmountOfGrades; 

            yCoord += 40;
            graphics.drawString(String.format("%d.", counter), 120, yCoord);
            graphics.drawString(name, 160, yCoord);
            graphics.drawString(String.format("%.2f", averageGrade < 3 ? 2 : averageGrade), 560, yCoord);
            counter++;
           
        }
        
        backToMenuButton.draw(graphics);
    }

    @Override
    public void update() {

    }
}
