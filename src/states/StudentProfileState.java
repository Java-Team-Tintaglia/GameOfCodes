package states;

import authentication.AuthenticationProvider;
import graphics.Assets;
import models.*;
import models.Button;
import repositories.StudentScoresRepository;
import utils.Constants;
import utils.Utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class StudentProfileState extends State {
    public static StringBuilder firstName = new StringBuilder(
            AuthenticationProvider.currentUser.getFirstName());

    public static StringBuilder lastName = new StringBuilder(
            AuthenticationProvider.currentUser.getLastName());

    public static Button backToMenuButton = new Button(300, 510, Assets.buttonBackToMenu);
    public static Button editButton = new Button(550, 510, Assets.buttonEdit);

    public static TreeMap<String, ArrayList<Integer>> grades = new TreeMap<>(
            StudentScoresRepository.getAllGrades(AuthenticationProvider.currentUser.getFirstName()));



    double averageGradeCSharp = grades.get("C#").stream().mapToDouble(s -> s.intValue()).average().getAsDouble();
    double averageJava = grades.get("Java").stream().mapToDouble(s -> s.intValue()).average().getAsDouble();
    double averageCPlusPlus = grades.get("C++").stream().mapToDouble(s -> s.intValue()).average().getAsDouble();
    double averageJavaScript = grades.get("JavaScript").stream().mapToDouble(s -> s.intValue()).average().getAsDouble();
    double averagePhp = grades.get("PHP").stream().mapToDouble(s -> s.intValue()).average().getAsDouble();






    @Override
    public void draw(Graphics graphics) {
        int fieldNameX = 220;
        int fieldNameY = 208;
        int rectBoxX = 420;
        int rectBoxY = 182;

        graphics.drawImage(Assets.wall, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.fillRect(100, 40, 824, 450);


        Font title = new Font("Arial", Font.PLAIN, 35);
        graphics.setFont(title);
        graphics.setColor(Color.white);
        String userProfile = AuthenticationProvider.currentUser.getUsername();
        graphics.drawString("User: " + userProfile, 390, 90);

        Font fieldName = new Font("Arial", Font.PLAIN, 25);
        graphics.setFont(fieldName);
        graphics.drawString("First Name:  " + firstName.toString(), fieldNameX, fieldNameY);
        graphics.drawString("Last Name:  " + lastName.toString(), fieldNameX + 350, fieldNameY);

        //Grades
        graphics.drawString("GRADES", fieldNameX + 250, fieldNameY + 60);

        graphics.drawString("C#:               " +  String.format("%.1f", averageGradeCSharp)  + " " , fieldNameX, fieldNameY + 80);
        graphics.drawString("Java:            " +  String.format("%.1f", averageJava) + " " , fieldNameX, fieldNameY + 110);
        graphics.drawString("C++:             " +  String.format("%.1f", averageCPlusPlus) + " " , fieldNameX, fieldNameY + 140);
        graphics.drawString("JavaScript:   " +  String.format("%.1f", averageJavaScript) + " " , fieldNameX, fieldNameY + 170);
        graphics.drawString("PHP:            " +  String.format("%.1f", averagePhp) + " " , fieldNameX, fieldNameY + 200);

        graphics.setColor(Color.gray);



        //Font inputText = new Font("Arial", Font.BOLD, 20);
        //graphics.setFont(inputText);
        //graphics.setColor(Color.black);


        backToMenuButton.draw(graphics);
        editButton.draw(graphics);



    }

    @Override
    public void update() {

    }
  }
