package states;

import authentication.AuthenticationProvider;
import graphics.Assets;
import models.Button;
import repositories.StudentScoresRepository;
import utils.Constants;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class StudentProfileState extends State {

    public static StringBuilder firstName = new StringBuilder(
            AuthenticationProvider.currentUser.getFirstName());

    public static StringBuilder lastName = new StringBuilder(
            AuthenticationProvider.currentUser.getLastName());

    public static Button backToMenuButton = new Button(550, 520, Assets.buttonBackToMenu);
    public static Button editButton = new Button(450, 200, Assets.buttonEdit);
    
    private StudentScoresRepository studentScoresRepository;

    public StudentProfileState(StudentScoresRepository studentScoresRepository) {
    	this.studentScoresRepository = studentScoresRepository;
    }
    
    @Override
    public void draw(Graphics graphics) {
        int scorePosition = 0;

        graphics.drawImage(Assets.background, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.fillRect(100, 40, 824, 460);

        Font title = new Font("Arial", Font.BOLD, 28);
        graphics.setFont(title);
        graphics.setColor(Color.white);
        String userProfile = AuthenticationProvider.currentUser.getUsername();
        graphics.drawString("User: " + userProfile, 450, 90);

        Font fieldName = new Font("Arial", Font.BOLD, 23);
        graphics.setFont(fieldName);
        graphics.drawString("First Name:", 390, 140);
        graphics.drawString(firstName.toString(), 590, 140);
        
        graphics.drawString("Last Name:", 390, 180);
        graphics.drawString(lastName.toString(), 590, 180);

        TreeMap<String, ArrayList<Integer>> gradesBySubject = new TreeMap<>(
        		studentScoresRepository.getAllGradesBySubject(AuthenticationProvider.currentUser.getFirstName()));
        
        graphics.drawString("GRADES:", 470, 290);
        
        Font font = new Font("Arial", Font.ITALIC, 24);
        graphics.setFont(font);
        if (!gradesBySubject.isEmpty()) {
        	for (Entry<String, ArrayList<Integer>> entry : gradesBySubject.entrySet()) {
    			double averageGrade = entry.getValue().stream().mapToDouble(s -> s.intValue()).average().getAsDouble();
    			 graphics.drawString(entry.getKey() + ":", 390, 340 + scorePosition);
    			 graphics.drawString(String.format("%.2f", averageGrade), 590, 340 + scorePosition);
    			 scorePosition += 30;
            }
		} else {
			 graphics.drawString("List is empty", 440, 340);
		}
        
        graphics.setColor(Color.gray);

        backToMenuButton.draw(graphics);
        editButton.draw(graphics);

    }

    @Override
    public void update() {
    }

}
