package states;

import authentication.AuthenticationProviderImpl;
import constants.Coordinates;
import constants.Fonts;
import constants.Messages;
import graphics.Assets;
import interfaces.State;
import interfaces.StudentScoresRepository;
import models.ButtonImpl;
import interfaces.AuthenticationProvider;
import interfaces.Button;
import repositories.StudentScoresRepositoryImpl;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class StudentProfileState implements State {
    
    public static Button backToMenuButton = new ButtonImpl(
    												Coordinates.STUDENT_PROFILE_STATE_BACK_BUTTON_X,
    												Coordinates.STUDENT_PROFILE_STATE_BACK_BUTTON_Y, 
    												Assets.buttonBackToMenu);
    
    public static Button editButton = new ButtonImpl(
    											Coordinates.STUDENT_PROFILE_STATE_EDIT_BUTTON_X,
    											Coordinates.STUDENT_PROFILE_STATE_EDIT_BUTTON_Y, 
    											Assets.buttonEdit);

    public static StringBuilder firstName;
    public static StringBuilder lastName;
    
    private StudentScoresRepository studentScoresRepository;
    private AuthenticationProvider authenticationProvider;

    public StudentProfileState(StudentScoresRepository studentScoresRepository, AuthenticationProvider authenticationProvider) {
    	this.studentScoresRepository = studentScoresRepository;
    	this.authenticationProvider = authenticationProvider;
    	firstName = new StringBuilder(this.authenticationProvider.getLoggedUser().getFirstName());
    	lastName = new StringBuilder(this.authenticationProvider.getLoggedUser().getLastName());
    }
    
    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.background, 0, 0, Coordinates.SCREEN_WIDTH, Coordinates.SCREEN_HEIGHT, null);
        
        graphics.fillRect(
        		Coordinates.STUDENT_PROFILE_STATE_RECTANGLE_BOX_X, 
        		Coordinates.STUDENT_PROFILE_STATE_RECTANGLE_BOX_Y, 
        		Coordinates.STUDENT_PROFILE_STATE_RECTANGLE_BOX_WIDTH, 
        		Coordinates.STUDENT_PROFILE_STATE_RECTANGLE_BOX_HEIGHT);

        Font title = new Font(Fonts.ARIAL_FONT, Font.BOLD, Fonts.TITLE_FONT_SIZE);
        graphics.setFont(title);
        graphics.setColor(Color.white);
        String username = this.authenticationProvider.getLoggedUser().getUsername();
        
        graphics.drawString(
        		"User: " + username, 
        		Coordinates.STUDENT_PROFILE_STATE_TITLE_X, 
        		Coordinates.STUDENT_PROFILE_STATE_TITLE_Y);

        Font fieldName = new Font(Fonts.ARIAL_FONT, Font.BOLD, Fonts.TEXT_FONT_SIZE);
        graphics.setFont(fieldName);
        
        graphics.drawString(
        		"First Name:", 
        		Coordinates.STUDENT_PROFILE_STATE_FIELD_NAME_X, 
        		Coordinates.STUDENT_PROFILE_STATE_FIELD_NAME_Y);
        
        graphics.drawString(
        		firstName.toString(), 
        		Coordinates.STUDENT_PROFILE_STATE_FIELD_PLAYER_NAME_X, 
        		Coordinates.STUDENT_PROFILE_STATE_FIELD_NAME_Y);
        
        graphics.drawString(
        		"Last Name:", 
        		Coordinates.STUDENT_PROFILE_STATE_FIELD_NAME_X,
        		Coordinates.STUDENT_PROFILE_STATE_FIELD_NAME_Y 
        		+ Coordinates.STUDENT_PROFILE_STATE_OFFSET_NAME);
        
        graphics.drawString(
        		lastName.toString(), 
        		Coordinates.STUDENT_PROFILE_STATE_FIELD_PLAYER_NAME_X, 
        		Coordinates.STUDENT_PROFILE_STATE_FIELD_NAME_Y 
        		+ Coordinates.STUDENT_PROFILE_STATE_OFFSET_NAME);

        TreeMap<String, ArrayList<Integer>> gradesBySubject = new TreeMap<>(
        		studentScoresRepository.getAllGradesBySubject(this.authenticationProvider.getLoggedUser().getUsername()));
        
        graphics.drawString(
        		"GRADES:", 
        		Coordinates.STUDENT_PROFILE_STATE_TITLE_GRADES_X, 
        		Coordinates.STUDENT_PROFILE_STATE_TITLE_GRADES_Y);
        
        Font font = new Font("Arial", Font.ITALIC, Fonts.TEXT_FONT_SIZE);
        graphics.setFont(font);
        
        int scorePosition = 0;
        if (!gradesBySubject.isEmpty()) {
        	for (Entry<String, ArrayList<Integer>> entry : gradesBySubject.entrySet()) {
    			double averageGrade = entry.getValue().stream()
    					.mapToDouble(s -> s.intValue())
    					.average()
    					.getAsDouble();
    			
    			 graphics.drawString(entry.getKey() + ":", 
    					 Coordinates.STUDENT_PROFILE_STATE_SUBJECT_NAME_X, 
    					 Coordinates.STUDENT_PROFILE_STATE_SUBJECT_NAME_Y + scorePosition);
    			 
    			 graphics.drawString(String.format("%.2f", averageGrade), 
    					 Coordinates.STUDENT_PROFILE_STATE_AVERAGE_GRADE_X, 
    					 Coordinates.STUDENT_PROFILE_STATE_SUBJECT_NAME_Y + scorePosition);
    			 
    			 scorePosition += Coordinates.STUDENT_PROFILE_STATE_OFFSET_SCORE;
            }
		} else {
			 graphics.drawString(
					 Messages.EMPTY_LIST, 
					 Coordinates.STUDENT_PROFILE_STATE_EMPTY_LIST_X, 
					 Coordinates.STUDENT_PROFILE_STATE_EMPTY_LIST_Y);
		}
        
        graphics.setColor(Color.gray);
        backToMenuButton.draw(graphics);
        editButton.draw(graphics);
    }

    @Override
    public void update() {
    }

}
