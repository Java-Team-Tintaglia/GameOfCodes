package states;

import authentication.AuthenticationProvider;
import constants.Common;
import constants.Coordinates;
import constants.Fonts;
import graphics.Assets;
import interfaces.State;
import interfaces.Student;
import models.ButtonImpl;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class StudentScoreState implements State {

    public static ButtonImpl backToMenuButton = new ButtonImpl(
                                                        Coordinates.STUDENT_SCORE_STATE_BACK_BUTTON_X,
                                                        Coordinates.STUDENT_SCORE_STATE_BACK_BUTTON_Y,
                                                        Assets.buttonBackToMenu);

    private Student student;

    public StudentScoreState(Student student) {
		this.student = student;
	}

    public Student getStudent() {
        return this.student;
    }

	@Override
    public void draw(Graphics graphics) {
    	graphics.drawImage(Assets.diploma, 0, 0, Coordinates.SCREEN_WIDTH, Coordinates.SCREEN_HEIGHT, null);

        Font fullNameFont = new Font(Fonts.ARIAL_FONT, Font.BOLD, Fonts.USER_FULL_NAME_FONT_SIZE);
        graphics.setFont(fullNameFont);
        graphics.setColor(Color.green);

        String fullName = AuthenticationProvider.currentUser.getFirstName() +  " "
        		+ AuthenticationProvider.currentUser.getLastName();

    	graphics.drawString(
                        fullName,
                        Coordinates.STUDENT_SCORE_STATE_FULL_NAME_X,
                        Coordinates.STUDENT_SCORE_STATE_FULL_NAME_Y);

        Font gradesFont = new Font(Fonts.ARIAL_FONT, Font.BOLD, Fonts.GRADES_FONT_SIZE);
        graphics.setFont(gradesFont);

        drawSubjectsAndGrades(graphics);

        backToMenuButton.draw(graphics);
    }

    @Override
    public void update() {}

    private void drawSubjectsAndGrades(Graphics graphics) {
        int currentSubjectAndGradeY = Coordinates.STUDENT_SCORE_STATE_SUBJECT_AND_GRADE_Y;

        for (Map.Entry<String, List<Integer>> entry : this.student.getStudentGrades().entrySet()) {
            double totalGrades = (double)entry.getValue().stream().mapToInt(Integer::intValue).sum();
            int totalAmountOfGrades = entry.getValue().size();
            double averageGrade = totalGrades / totalAmountOfGrades;

            String subject = entry.getKey();
            String averageGradeToString =
                    String.format("%.2f", averageGrade < Common.PASSABLE ? Common.FAILURE : averageGrade);

            graphics.drawString(
                    subject,
                    Coordinates.STUDENT_SCORE_STATE_SUBJECT_NAME_X,
                    currentSubjectAndGradeY);

            graphics.drawString(
                    averageGradeToString,
                    Coordinates.STUDENT_SCORE_STATE_AVERAGE_GRADE_X,
                    currentSubjectAndGradeY);

            currentSubjectAndGradeY += Coordinates.STUDENT_SCORE_STATE_SUBJECT_AND_GRADE_OFFSET;
        }
    }
}

