package models.students;

import graphics.SpriteSheet;
import models.GameObject;
import models.programmingLanguages.ProgrammingLanguage;
import utils.Constants;

import java.awt.*;

public abstract class Student extends GameObject {

    private static final int DEFAULT_SPEED = 3;

    private int x;
    private int y;
    private String name;
    private SpriteSheet spriteSheet;
    private int width;
    private int height;
    private int intelligence;
    private int knowledge;
    private int vitality;
    private Rectangle colliderBox;

    public static boolean isMovingLeft = false;
    public static boolean isMovingRight = false;
    public static boolean isMovingUp = false;
    public static boolean isMovingDown = false;

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
        // TODO Auto-generated method stub

    }


    @Override
    public void update() {
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
        int vitality = this.getVitality() - language.getVitalityDamagePoints();
        if (vitality <= 0) {
            vitality = 0;
        }
        int knowledge = this.getKnowledge() + language.getKnowledgePoints();
        int intelligence = this.getIntelligence();

        this.setVitality(vitality);
        this.setKnowledge(knowledge);

        int ratio = (vitality * knowledge) / intelligence;
        if (ratio <= 30) {
            return Constants.FAILURE;
        } else if (ratio > 30 && ratio <= 60) {
            return Constants.PASSABLE;
        } else if (ratio > 60 && ratio <= 80) {
            return Constants.GOOD;
        } else if (ratio > 80 && ratio <= 100) {
            return Constants.VERY_GOOD;
        } else {
            return Constants.EXCELLENT;
        }
    }
}
