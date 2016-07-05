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

    public Student(int x, int y, SpriteSheet spriteSheet,
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

	public String getUsername() {
		return username;
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

    public Map<String, List<Integer>> getStudentGrades() {
        return studentGrades;
    }

    public int getIntelligence() {
        return intelligence;
    }

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

    public int getKnowledge() {
        return knowledge;
    }

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

    public int getVitality() {
        return vitality;
    }

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

    public Rectangle getColliderBox() {
        return colliderBox;
    }

    public boolean isMovingLeft() {
		return isMovingLeft;
	}

	public void setMovingLeft(boolean isMovingLeft) {
		this.isMovingLeft = isMovingLeft;
	}

	public boolean isMovingRight() {
		return isMovingRight;
	}

	public void setMovingRight(boolean isMovingRight) {
		this.isMovingRight = isMovingRight;
	}

	public boolean isMovingUp() {
		return isMovingUp;
	}

	public void setMovingUp(boolean isMovingUp) {
		this.isMovingUp = isMovingUp;
	}

	public boolean isMovingDown() {
		return isMovingDown;
	}

	public void setMovingDown(boolean isMovingDown) {
		this.isMovingDown = isMovingDown;
	}

	@Override
    public void draw(Graphics graphics) {

        graphics.drawImage(this.spriteSheet.crop(col * width, row * height,
               this.width, this.height), this.getX(), this.getY(), null);
    }


    @Override
    public void update() {

        boolean isMoving= isMovingDown || isMovingUp || 
        					isMovingRight || isMovingLeft;
        
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

        if (ratio >= 0 && ratio <= 55) {
            grade = Constants.FAILURE;
        } else if (ratio > 55 && ratio <= 65) {
            grade = Constants.PASSABLE;
        } else if (ratio > 65 && ratio <= 75) {
            grade = Constants.GOOD;
        } else if (ratio > 75 && ratio <= 85) {
            grade = Constants.VERY_GOOD;
        } else {
            grade = Constants.EXCELLENT;
        }

        switch (grade) {
            case Constants.FAILURE:
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

        int vitality = this.getVitality() - language.getVitalityDamagePoints();
        this.setVitality(vitality);

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

    public void reduceValues() {
//        this.setVitality(this.getVitality() - 1);
        this.setKnowledge(this.getKnowledge() - 3);
        this.setIntelligence(this.getIntelligence() - 3);
    }
}
