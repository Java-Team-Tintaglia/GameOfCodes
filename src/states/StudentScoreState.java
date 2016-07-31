package states;

import java.awt.*;
import java.util.List;
import java.util.Map;

import authentication.AuthenticationProvider;
import graphics.Assets;
import interfaces.Student;
import models.Button;
import models.students.StudentImpl;
import utils.Constants;

public class StudentScoreState extends State {
    private Student student;

    private static int backToMenuButtonXCoord = 730;
    private static int backToMenuButtonYCoord = 520;
    private int userFullNameFontSize = 16;
    private int gradesFontSize = 20;
    private int subjectNameXCoord = 420;
    private int subjectAverageGradeXCoord = 570;
    public static Button backToMenuButton = new Button(backToMenuButtonXCoord,
            backToMenuButtonYCoord, Assets.buttonBackToMenu);

    public StudentScoreState(Student student) {
		this.student = student;
	}

	@Override
    public void draw(Graphics graphics) {
    	graphics.drawImage(Assets.diploma, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
    	graphics.setFont(new Font("Arial", Font.BOLD, userFullNameFontSize));
        graphics.setColor(Color.green);
        
        String fullName = AuthenticationProvider.currentUser.getFirstName() +  " "
        		+ AuthenticationProvider.currentUser.getLastName();
    	graphics.drawString(fullName, 510, 205);
        
    	graphics.setFont(new Font("Arial", Font.BOLD, gradesFontSize));
    	int currentY = 280;
        for (Map.Entry<String, List<Integer>> entry : this.student.getStudentGrades().entrySet()) {
            double totalGrades = (double)entry.getValue().stream().mapToInt(Integer::intValue).sum();
            int totalAmountOfGrades = entry.getValue().size();
        	double averageGrade = totalGrades / totalAmountOfGrades;
        	
            graphics.drawString(entry.getKey(), subjectNameXCoord, currentY);
            graphics.drawString(String.format("%.2f", averageGrade < 3 ? 2 : averageGrade), subjectAverageGradeXCoord, currentY);
            currentY+=40;
        }
        
        backToMenuButton.draw(graphics);
    }

    @Override
    public void update() {
    }

    public Student getStudent() {
    	return this.student;
    }
    
}

