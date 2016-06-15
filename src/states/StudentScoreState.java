package states;


import models.students.Student;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

public class StudentScoreState extends State {

    private Student student;

    public StudentScoreState(Student student){
        this.student = student;
    }

        @Override
        public void draw(Graphics graphics) {
            graphics.drawString(this.student.getName(),100,200);

            int currentY = 100;
            for (Map.Entry<String,java.util.List<Integer>> entry : this.student.getStudentGrades().entrySet()) {
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
        }

        @Override
        public void update() {

        }

}

