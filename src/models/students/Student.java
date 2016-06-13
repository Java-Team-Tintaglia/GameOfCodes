package models.students;

import enums.ProgrammingLanguageType;
import graphics.Assets;
import graphics.SpriteSheet;
import models.GameObject;
import models.programmingLanguages.ProgrammingLanguage;
import utils.Constants;

import java.awt.*;
import java.util.*;
import java.util.List;

public abstract class Student extends GameObject {

    private static final int DEFAULT_SPEED = 10;
    private int row;
    private int col;
    private String name;
    private SpriteSheet spriteSheet;
    private int width;
    private int height;
    private int intelligence;
    private int knowledge;
    private int vitality;
    private Rectangle colliderBox;
    private Map<ProgrammingLanguageType, List<Integer>> studentGrades;

    public static boolean isMovingLeft;
    public static boolean isMovingRight;
    public static boolean isMovingUp;
    public static boolean isMovingDown;

    public Student(int x, int y, SpriteSheet spriteSheet,
                   int width, int height, String name,
                   int intelligence, int knowledge, int vitality) {
        super(x, y);
        this.spriteSheet = spriteSheet;
        this.width = width;
        this.height = height;
        this.name = name;
        this.intelligence = intelligence;
        this.knowledge = knowledge;
        this.vitality = vitality;
        this.colliderBox = new Rectangle(this.getX(), this.getY(),
                this.width, this.height);
        this.studentGrades = new HashMap<>();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public Map<ProgrammingLanguageType, List<Integer>> getStudentGrades() {
        return studentGrades;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public Rectangle getColliderBox() {
        return colliderBox;
    }

    public boolean intersects(Rectangle boundingbox) {
        if (this.colliderBox.intersects(boundingbox) || boundingbox.intersects(this.colliderBox)) {
            return true;
        }
        return false;

    }


    @Override
    public void draw(Graphics graphics) {

        graphics.drawImage(Assets.nerds.crop(col * 50, row * 50,
                Constants.NERDBOY_WIDTH, Constants.NERDBOY_HEIGHT), this.getX(), this.getY(), null);


    }


    @Override
    public void update() {


        boolean ismoVing = isMovingDown || isMovingRight ||
                isMovingUp || isMovingLeft;
        if (ismoVing) {
            col++;
            col = (col + 1) % 3;

            if (isMovingLeft) {
                row = 1;

            } else if (isMovingRight) {
                row = 2;

            } else if (isMovingUp) {
                row = 3;


            } else if (isMovingDown) {

                row = 0;

            }


        } else {
            row = 0;
            col = 1;
        }
        this.getColliderBox().setBounds(this.getX(), this.getY(),
                this.width, this.height);
        move();
    }

    private void move() {
        if (isMovingRight && this.getX() + DEFAULT_SPEED <= 730) {
            this.setX(this.getX() + DEFAULT_SPEED);
        }
        if (isMovingLeft && this.getX() + DEFAULT_SPEED >= 0) {
            this.setX(this.getX() - DEFAULT_SPEED);
        }
        if (isMovingDown && this.getY() + DEFAULT_SPEED < 520) {
            this.setY(this.getY() + DEFAULT_SPEED);
        }
        if (isMovingUp && this.getY() - DEFAULT_SPEED >= 0) {
            this.setY(this.getY() - DEFAULT_SPEED);
        }
    }

    public int calculateGrade(ProgrammingLanguage language) {
        int grade = Constants.FAILURE;
        int ratio = (this.getKnowledge() * this.getVitality()) / this.getIntelligence();

        if (ratio <= 30) {
            grade = Constants.FAILURE;
        } else if (ratio > 30 && ratio <= 60) {
            grade = Constants.PASSABLE;
        } else if (ratio > 60 && ratio <= 80) {
            grade = Constants.GOOD;
        } else if (ratio > 80 && ratio <= 100) {
            grade = Constants.VERY_GOOD;
        } else {
            grade = Constants.EXCELLENT;
        }

        int vitality = this.getVitality() - language.getVitalityDamagePoints() <= 0 ? 0 : this.getVitality() - language.getVitalityDamagePoints();
        this.setVitality(vitality);

        switch (grade) {
            case 2:
                break;
            case 3:
                this.setKnowledge(this.getKnowledge() + (int) (language.getKnowledgePoints() * 0.3));
                break;
            case 4:
                this.setKnowledge(this.getKnowledge() + (int) (language.getKnowledgePoints() * 0.6));
                break;
            case 5:
                this.setKnowledge(this.getKnowledge() + (int) (language.getKnowledgePoints() * 0.8));
                break;
            case 6:
                this.setKnowledge(this.getKnowledge() + language.getKnowledgePoints());
                break;
            default:
                break;
        }

        return grade;
    }

    public void addScore(int grade, ProgrammingLanguage language) {
        
        if (!this.studentGrades.containsKey(language.getProgrammingLanguageType())) {
            this.studentGrades.put(language.getProgrammingLanguageType(), new ArrayList<>());
        }

        this.studentGrades.get(language.getProgrammingLanguageType()).add(grade);
    }
}
