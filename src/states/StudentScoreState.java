package states;

import java.awt.*;
import java.text.DecimalFormat;
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
        graphics.setFont(new Font("Arial", Font.BOLD, 17));
        graphics.setColor(Color.black);
    	graphics.drawImage(Assets.diploma, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        
    	graphics.drawString(this.student.getName(),510,205);
DecimalFormat df = new DecimalFormat("#.##");
        int currentY = 280;
        for (Map.Entry<String,List<Integer>> entry : this.student.getStudentGrades().entrySet()) {
            Double grade = 0d;
            int count = 0;
            for (Integer s : entry.getValue()) {
                grade+= s;
                count++;
            }
            grade/= count;
            graphics.drawString(entry.getKey(), 420, currentY);
            graphics.drawString(df.format(grade), 570, currentY);
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

