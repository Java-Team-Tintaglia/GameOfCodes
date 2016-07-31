package models.students;

import graphics.SpriteSheet;
import interfaces.ProgrammingLanguage;
import interfaces.Student;
import models.AbstractGameObject;
import models.programmingLanguages.AbstractProgrammingLanguage;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.*;

import constants.Common;

public abstract class AbstractStudent extends AbstractGameObject implements Student{

    private static final int DEFAULT_SPEED = 8;
    
    private int row;
    private int col;

    private SpriteSheet spriteSheet;
    private int width;
    private int height;
    private int intelligence;
    private int knowledge;
    private int vitality;
    
    private Rectangle colliderBox;
    private Map<String, List<Integer>> studentGrades;
    private String username;

    private boolean isMovingLeft;
    private boolean isMovingRight;
    private boolean isMovingUp;
    private boolean isMovingDown;

    public AbstractStudent(int x, int y, SpriteSheet spriteSheet,
                       int width, int height,
                       int intelligence, int knowledge, int vitality,
                       String username) {
        super(x, y);
        
        this.spriteSheet = spriteSheet;
        this.width = width;
        this.height = height;  
        this.username = username;
        this.intelligence = intelligence;
        this.knowledge = knowledge;
        this.vitality = vitality;
        this.colliderBox = new Rectangle(this.getX(), this.getY(),
                this.width, this.height);
        
        this.studentGrades = new HashMap<>();
    }	
    @Override
	public String getUsername() {
		return this.username;
	}

	public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    @Override
    public Map<String, List<Integer>> getStudentGrades() {
        return this.studentGrades;
    }
    @Override
    public int getIntelligence() {
        return this.intelligence;
    }
    @Override
    public void setIntelligence(int intelligence) {
        if (intelligence > 100) {
            this.intelligence = 100;
            return;
        }
        if (intelligence < 0) {
            this.intelligence = 0;
            return;
        }
        this.intelligence = intelligence;
    }
    @Override
    public int getKnowledge() {
        return this.knowledge;
    }
    @Override
    public void setKnowledge(int knowledge) {
        if (knowledge > 100) {
            this.knowledge = 100;
            return;
        }
        if (knowledge < 0) {
            this.knowledge = 0;
            return;
        }
        this.knowledge = knowledge;
    }
    @Override
    public int getVitality() {
        return this.vitality;
    }
    @Override
    public void setVitality(int vitality) {
        if (vitality > 100) {
            this.vitality = 100;
            return;
        }
        if (vitality < 0) {
            this.vitality = 0;
            return;
        }
        this.vitality = vitality;
    }
    @Override
    public Rectangle getColliderBox() {
        return this.colliderBox;
    }
    @Override
    public boolean isMovingLeft() {
		return this.isMovingLeft;
	}
    @Override
	public void setMovingLeft(boolean isMovingLeft) {
		this.isMovingLeft = isMovingLeft;
	}
    @Override
	public boolean isMovingRight() {
		return this.isMovingRight;
	}
    @Override
	public void setMovingRight(boolean isMovingRight) {
		this.isMovingRight = isMovingRight;
	}
    @Override
	public boolean isMovingUp() {
		return this.isMovingUp;
	}
    @Override
	public void setMovingUp(boolean isMovingUp) {
		this.isMovingUp = isMovingUp;
	}
    @Override
	public boolean isMovingDown() {
		return this.isMovingDown;
	}
    @Override
	public void setMovingDown(boolean isMovingDown) {
		this.isMovingDown = isMovingDown;
	}

	@Override
    public void draw(Graphics graphics) {
        graphics.drawImage(this.spriteSheet.crop(this.col * this.width, this.row * this.height,
               this.width, this.height), this.getX(), this.getY(), null);
    }


    @Override
    public void update() {

        boolean isMoving= this.isMovingDown || this.isMovingUp || 
        		this.isMovingRight || this.isMovingLeft;
        
        if (isMoving) {
        	this.col++;
        	this.col = (this.col) % 3;

            if (this.isMovingLeft) {
            	this.row = 1;
            } else if (this.isMovingRight) {
            	this.row = 2;
            } else if (this.isMovingUp) {
            	this.row = 3;
            } else if (this.isMovingDown) {
            	this.row = 0;
            }
        } else {
        	this.row = 0;
        	this.col = 1;
        }
        
        this.getColliderBox().setBounds(this.getX(), this.getY(),
                this.width, this.height);
        move();
    }
    @Override
    public int calculateGrade(ProgrammingLanguage language) {
        int grade = Common.FAILURE;
        int ratio = (this.getKnowledge() + this.getVitality() + this.getIntelligence()) / 3;

        if (ratio >= 0 && ratio <= 50) {
            grade = Common.FAILURE;
        } else if (ratio > 50 && ratio <= 60) {
            grade = Common.PASSABLE;
        } else if (ratio > 60 && ratio <= 75) {
            grade = Common.GOOD;
        } else if (ratio > 75 && ratio <= 90) {
            grade = Common.VERY_GOOD;
        } else {
            grade = Common.EXCELLENT;
        }

        switch (grade) {
            case Common.FAILURE:
                break;
            case Common.PASSABLE:
                this.setKnowledge(this.getKnowledge() + (int) (language.getKnowledgePoints() * 0.3));
                break;
            case Common.GOOD:
                this.setKnowledge(this.getKnowledge() + (int) (language.getKnowledgePoints() * 0.6));
                break;
            case Common.VERY_GOOD:
                this.setKnowledge(this.getKnowledge() + (int) (language.getKnowledgePoints() * 0.8));
                break;
            case Common.EXCELLENT:
                this.setKnowledge(this.getKnowledge() + language.getKnowledgePoints());
                break;
        }

        int vitality = this.getVitality() - language.getVitalityDamagePoints();
        this.setVitality(vitality);

        return grade;
    }
    @Override
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
    @Override
    public void getExhausted() {
        this.setVitality(this.getVitality() - 1);
    }
}
