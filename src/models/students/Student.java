package models.students;

import graphics.SpriteSheet;
import models.GameObject;
import models.programmingLanguages.ProgrammingLanguage;
import utils.Constants;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.*;

public abstract class Student extends GameObject {

    private static final int DEFAULT_SPEED = 8;
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
    private Map<String, List<Integer>> studentGrades;

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

    public Map<String, List<Integer>> getStudentGrades() {
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


    @Override
    public void draw(Graphics graphics) {

        graphics.drawImage(this.spriteSheet.crop(col * width, row * height,
               this.width, this.height), this.getX(), this.getY(), null);
    }


    @Override
    public void update() {

        boolean isMoving= isMovingDown || 
        		isMovingRight ||
                isMovingUp || 
                isMovingLeft;
        
        if (isMoving) {
            col++;
            col = (col ) % 3;

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

    public int calculateGrade(ProgrammingLanguage language) {
        int grade = Constants.FAILURE;
        int ratio = (this.getKnowledge() + this.getVitality() + this.getIntelligence()) / 3;
        int random = new Random().nextInt(ratio);

        if (this.vitality <= 0 || random <= (0.2 * ratio)) {
            grade = Constants.FAILURE;
        } else if (random > (0.2 * ratio) && random <= (0.4 * ratio)) {
            grade = Constants.PASSABLE;
        } else if (random > (0.4 * ratio) && random <= (0.6 * ratio)) {
            grade = Constants.GOOD;
        } else if (random > (0.6 * ratio) && random <= (0.8 * ratio)) {
            grade = Constants.VERY_GOOD;
        } else {
            grade = Constants.EXCELLENT;
        }

        switch (grade) {
            case Constants.FAILURE:
                int vitality = this.getVitality() - language.getVitalityDamagePoints() <= 0 ? 0 : this.getVitality() - language.getVitalityDamagePoints();
                this.setVitality(vitality);
                break;
            case Constants.PASSABLE:
                this.setKnowledge(this.getKnowledge() + (int) (language.getKnowledgePoints() * 0.3));
                break;
            case Constants.GOOD:
                this.setKnowledge(this.getKnowledge() + (int) (language.getKnowledgePoints() * 0.6));
                break;
            case Constants.VERY_GOOD:
                this.setKnowledge(this.getKnowledge() + (int) (language.getKnowledgePoints() * 0.8));
                break;
            case Constants.EXCELLENT:
                this.setKnowledge(this.getKnowledge() + language.getKnowledgePoints());
                break;
        }

        return grade;
    }

    public void addScore(int grade, ProgrammingLanguage language) {
        
        if (!this.studentGrades.containsKey(language.getProgrammingLanguageType().getName())) {
            this.studentGrades.put(language.getProgrammingLanguageType().getName(), new ArrayList<>());
        }

        this.studentGrades.get(language.getProgrammingLanguageType().getName()).add(grade);
    }
    
    private void move() {
        if (isMovingRight && this.getX() + DEFAULT_SPEED <= 988) {
            this.setX(this.getX() + DEFAULT_SPEED);
        }
        if (isMovingLeft && this.getX() + DEFAULT_SPEED >= 11) {
            this.setX(this.getX() - DEFAULT_SPEED);
        }
        if (isMovingDown && this.getY() + DEFAULT_SPEED < 560) {
            this.setY(this.getY() + DEFAULT_SPEED);
        }
        if (isMovingUp && this.getY() - DEFAULT_SPEED >= 255) {
            this.setY(this.getY() - DEFAULT_SPEED);
        }
    }
}
