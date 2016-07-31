package states;

import graphics.Assets;
import models.ButtonImpl;
import repositories.StudentScoresRepository;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import constants.Common;

public class ScoresState extends State {
    private StudentScoresRepository studentScoresRepository;
    private static int backToMenuButtonXCoord = 730;
    private static int backToMenuButtonYCoord = 500;
    private int fontSize = 25;
    private int playerNameXCoord = 160;
    private int counterXCoord = 120;
    private int averageGradeXCoord = 520;
    private int subjectAverageGradeXCoord = 560;

    public static ButtonImpl backToMenuButton = new ButtonImpl(backToMenuButtonXCoord,
            backToMenuButtonYCoord, Assets.buttonBackToMenu);

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
        
        graphics.drawImage(Assets.highScoresBackground, 0, 0, Common.SCREEN_WIDTH, Common.SCREEN_HEIGHT, null);

        Font font = new Font("Consolas", Font.PLAIN, fontSize);
        graphics.setFont(font);
        graphics.setColor(Color.white);
        graphics.drawString("Player name", playerNameXCoord, yCoord);
        graphics.drawString("Average grade", averageGradeXCoord, yCoord);
   
        int counter = 1;
        for(Entry<String, List<Integer>> entry : sorted.entrySet()){
            String name = entry.getKey();
            
            double totalGrades = (double)entry.getValue().stream().mapToInt(Integer::intValue).sum();
            double totalAmountOfGrades = (double)entry.getValue().size();
        	double averageGrade = totalGrades / totalAmountOfGrades; 

            yCoord += 40;
            graphics.drawString(String.format("%d.", counter), counterXCoord, yCoord);
            graphics.drawString(name, playerNameXCoord, yCoord);
            graphics.drawString(String.format("%.2f", averageGrade < 3 ? 2 : averageGrade), subjectAverageGradeXCoord, yCoord);
            counter++;
           
        }
        
        backToMenuButton.draw(graphics);
    }

    @Override
    public void update() {

    }
}
