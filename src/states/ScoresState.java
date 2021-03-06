package states;

import constants.Coordinates;
import constants.Fonts;
import enums.Grades;
import graphics.Assets;
import interfaces.Button;
import interfaces.State;
import interfaces.StudentScoresRepository;
import models.ButtonImpl;
import repositories.StudentScoresRepositoryImpl;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ScoresState implements State {

    private static final int DEFAULT_EXPOSED_USERS_COUNT = 10;

    public static Button backToMenuButton = new ButtonImpl(
                                                    Coordinates.SCORE_STATE_BACK_BUTTON_X,
                                                    Coordinates.SCORE_STATE_BACK_BUTTON_Y,
                                                    Assets.buttonBackToMenu);

    private StudentScoresRepository studentScoresRepository;

    public ScoresState(StudentScoresRepository studentScoresRepository) {
    	this.studentScoresRepository = studentScoresRepository;
    	this.studentScoresRepository.readFromFile();
    }
	    
	@Override
    public void draw(Graphics graphics) {

        Map<String, List<Integer>> sorted = StudentScoresRepositoryImpl.studentsScore.entrySet()
				.stream()
				.sorted((a, b) ->
                        Double.compare((double)b.getValue().stream().mapToInt(Integer::intValue).sum() / b.getValue().size(),
						                (double)a.getValue().stream().mapToInt(Integer::intValue).sum() / a.getValue().size()))
				.limit(DEFAULT_EXPOSED_USERS_COUNT)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));
        
        graphics.drawImage(Assets.highScoresBackground, 0, 0, Coordinates.SCREEN_WIDTH, Coordinates.SCREEN_HEIGHT, null);

        Font font = new Font(Fonts.CONSOLAS_FONT, Font.PLAIN, Fonts.PLAYER_NAME_AND_GRADE_FONT_SIZE);
        graphics.setFont(font);
        graphics.setColor(Color.white);

        String playerNameTitle = "Player name";
        String averageGradeTitle = "Average grade";

        graphics.drawString(
                        playerNameTitle,
                        Coordinates.SCORE_STATE_PLAYER_NAME_TITLE_X,
                        Coordinates.SCORE_STATE_DEFAULT_OBJECT_Y);

        graphics.drawString(
                        averageGradeTitle,
                        Coordinates.SCORE_STATE_AVERAGE_GRADE_TITLE_X,
                        Coordinates.SCORE_STATE_DEFAULT_OBJECT_Y);

        drawCountersSubjectsAndGrades(graphics, sorted);
        backToMenuButton.draw(graphics);
    }

    @Override
    public void update() {}

    private void drawCountersSubjectsAndGrades(Graphics graphics, Map<String, List<Integer>> sorted) {
        int counter = 1;
        int startObjectCoordY = Coordinates.SCORE_STATE_DEFAULT_OBJECT_Y + Coordinates.SCORE_STATE_OBJECT_OFFSET_Y;

        for(Entry<String, List<Integer>> entry : sorted.entrySet()){
            String name = entry.getKey();
            double totalGrades = (double)entry.getValue().stream().mapToInt(Integer::intValue).sum();
            double totalAmountOfGrades = (double)entry.getValue().size();
            double averageGrade = totalGrades / totalAmountOfGrades;

            String counterToString = String.format("%d.", counter);
            String gradeToString = String.format("%.2f", 
            		averageGrade < Grades.PASSABLE.getGrade() ? Grades.FAILURE.getGrade() : averageGrade);

            graphics.drawString(counterToString, Coordinates.SCORE_STATE_COUNTER_X, startObjectCoordY);
            graphics.drawString(name, Coordinates.SCORE_STATE_SUBJECT_NAME_X, startObjectCoordY);
            graphics.drawString(gradeToString, Coordinates.SCORE_STATE_SUBJECT_AVERAGE_GRADE_X, startObjectCoordY);

            startObjectCoordY += Coordinates.SCORE_STATE_OBJECT_OFFSET_Y;
            counter++;
        }
    }
}
