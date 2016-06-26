package states;

import java.awt.*;
import java.util.List;
import java.util.Map;

import authentication.AuthenticationProvider;
import graphics.Assets;
import models.Button;
import models.students.Student;
import utils.Constants;

public class StudentScoreState extends State {

    private Student student;

    public static Button backToMenuButton = new Button(730, 520, Assets.buttonBackToMenu);

    public StudentScoreState(Student student) {
		this.student = student;
	}


	@Override
    public void draw(Graphics graphics) {
    	graphics.drawImage(Assets.diploma, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
    	graphics.setFont(new Font("Arial", Font.BOLD, 16));
        graphics.setColor(Color.green);
        
        String fullName = AuthenticationProvider.currentUser.getFirstName() +  " "
        		+ AuthenticationProvider.currentUser.getLastName();
    	graphics.drawString(fullName,510,205);
        
    	graphics.setFont(new Font("Arial", Font.BOLD, 20));
    	int currentY = 280;
        for (Map.Entry<String, List<Integer>> entry : this.student.getStudentGrades().entrySet()) {
            double totalGrades = (double)entry.getValue().stream().mapToInt(Integer::intValue).sum();
            int totalAmountOfGrades = entry.getValue().size();
        	double averageGrade = totalGrades / totalAmountOfGrades;
        	
            graphics.drawString(entry.getKey(), 420, currentY);
            graphics.drawString(String.format("%.2f", averageGrade < 3 ? 2 : averageGrade), 570, currentY);
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

