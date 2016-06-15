package states;

import java.awt.Graphics;
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
        
    	graphics.drawString(this.student.getName(),100,200);

        int currentY = 100;
        for (Map.Entry<String,List<Integer>> entry : this.student.getStudentGrades().entrySet()) {
            Double grade = 0d;
            int count = 0;
            for (Integer s : entry.getValue()) {
                grade+= s;
                count++;
            }
            grade/= count;
            graphics.drawString(entry.getKey(), 100, currentY);
            graphics.drawString(grade.toString(), 200, currentY);
            currentY+=100;
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

