package states;

import authentication.AuthenticationProvider;
import graphics.Assets;
import models.ButtonImpl;
import repositories.StudentScoresRepository;
import utils.Constants;
import utils.Coordinates;
import utils.Messages;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class StudentProfileState extends State {
    private static final int SCORE_OFFSET=30;
    private StudentScoresRepository studentScoresRepository;

    private static int backToMenuButtonXCoord  = 550;
    private static int backToMenuButtonYCoord = 520;
    private static int editButtonXCoord = 450;
    private static int editButtonYCoord = 200;
    private int scorePosition = 0;
    private int rectangleXCoord = 100;
    private int rectangleYCoord = 40;
    private int rectangleWidth = 824;
    private int rectangleHeight = 460;
    private int titleFontSize = 28;
    private int titleXCoord = 450;
    private int titleYCoord = 90;
    private int fieldFontSize = 23;
    private int fieldNameXCoord = 390;
    private int nameYCoord = 140;
    private int playerNameXCoord = 590;
    private int gradesTitleXCoord = 470;
    private int gradesTitleYCoord = 290;
    private int gradesFontSize = 24;
    private int subjectNameXCoord = 390;
    private int subjectYCoord = 340;
    private int averageGradeXCoord = 590;
    private int emptyListMessageXCoord = 440;
    private int emptyListMessageYCoord = 340;

    public static StringBuilder firstName = new StringBuilder(
            AuthenticationProvider.currentUser.getFirstName());

    public static StringBuilder lastName = new StringBuilder(
            AuthenticationProvider.currentUser.getLastName());

    public static ButtonImpl backToMenuButton = new ButtonImpl(backToMenuButtonXCoord,
            backToMenuButtonYCoord, Assets.buttonBackToMenu);
    public static ButtonImpl editButton = new ButtonImpl(editButtonXCoord,
            editButtonYCoord, Assets.buttonEdit);

    public StudentProfileState(StudentScoresRepository studentScoresRepository) {
    	this.studentScoresRepository = studentScoresRepository;
    }
    
    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.background, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.fillRect(rectangleXCoord, rectangleYCoord, rectangleWidth, rectangleHeight);

        Font title = new Font("Arial", Font.BOLD, titleFontSize);
        graphics.setFont(title);
        graphics.setColor(Color.white);
        String userProfile = AuthenticationProvider.currentUser.getUsername();
        graphics.drawString("User: " + userProfile, titleXCoord, titleYCoord);

        Font fieldName = new Font("Arial", Font.BOLD, fieldFontSize);
        graphics.setFont(fieldName);
        graphics.drawString("First Name:", fieldNameXCoord, nameYCoord);
        graphics.drawString(firstName.toString(), playerNameXCoord, nameYCoord);
        
        graphics.drawString("Last Name:", fieldNameXCoord, nameYCoord + Coordinates.STUDENT_PROFILE_STATE_OFFSET_NAME_Y);
        graphics.drawString(lastName.toString(), playerNameXCoord, nameYCoord + Coordinates.STUDENT_PROFILE_STATE_OFFSET_NAME_Y);

        TreeMap<String, ArrayList<Integer>> gradesBySubject = new TreeMap<>(
        		studentScoresRepository.getAllGradesBySubject(AuthenticationProvider.currentUser.getFirstName()));
        
        graphics.drawString("GRADES:", gradesTitleXCoord, gradesTitleYCoord);
        
        Font font = new Font("Arial", Font.ITALIC, gradesFontSize);
        graphics.setFont(font);
        if (!gradesBySubject.isEmpty()) {
        	for (Entry<String, ArrayList<Integer>> entry : gradesBySubject.entrySet()) {
    			double averageGrade = entry.getValue().stream().mapToDouble(s -> s.intValue()).average().getAsDouble();
    			 graphics.drawString(entry.getKey() + ":", subjectNameXCoord, subjectYCoord + scorePosition);
    			 graphics.drawString(String.format("%.2f", averageGrade), averageGradeXCoord, subjectYCoord + scorePosition);
    			 scorePosition += SCORE_OFFSET;
            }
		} else {
			 graphics.drawString(Messages.EMPTY_LIST, emptyListMessageXCoord, emptyListMessageYCoord);
		}
        
        graphics.setColor(Color.gray);

        backToMenuButton.draw(graphics);
        editButton.draw(graphics);

    }

    @Override
    public void update() {
    }

}
