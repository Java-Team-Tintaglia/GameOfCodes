package states;

import java.awt.*;
import java.util.List;
import java.util.Map;

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
    	graphics.setFont(new Font("Arial", Font.BOLD, 20));
        graphics.setColor(Color.green);
        
    	graphics.drawString(this.student.getUsername(),510,205);
        
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

