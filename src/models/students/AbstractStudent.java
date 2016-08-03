
package models.students;

import static enums.Grades.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import enums.Grades;
import graphics.SpriteSheet;
import interfaces.ProgrammingLanguage;
import interfaces.Student;
import models.AbstractGameObject;

public abstract class AbstractStudent extends AbstractGameObject implements Student {

    private static final int DEFAULT_SPEED = 8;
    private static final int MAX_STAT_POINTS = 100;
    private static final int MAX_RIGHT_POSITION = 988;
    private static final int MAX_LEFT_POSITION = 11;
    private static final int MAX_UP_POSITION = 255;
    private static final int MAX_DOWN_POSITION = 560;
    private static final int IMAGES_COUNT_IN_PICTURE = 3;
    private static final int FIRST_ROW = 0;
    private static final int SECOND_ROW = 1;
    private static final int THIRD_ROW = 2;
    private static final int FOURTH_ROW = 3;
    private static final int STATISTICS_COUNT = 3;

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
    private String fullName;

    private boolean isMovingLeft;
    private boolean isMovingRight;
    private boolean isMovingUp;
    private boolean isMovingDown;

    public AbstractStudent(int x, int y, SpriteSheet spriteSheet,
                       int width, int height,
                       int intelligence, int knowledge, int vitality,
                       String username, String fullName) {
        super(x, y);
        
        this.spriteSheet = spriteSheet;
        this.width = width;
        this.height = height;  
        this.username = username;
        this.fullName = fullName;
        this.intelligence = intelligence;
        this.knowledge = knowledge;
        this.vitality = vitality;
        this.colliderBox = new Rectangle(this.getX(), this.getY(),
                this.width, this.height);
        
        this.studentGrades = new HashMap<>();
    }

    @Override
    public String getFullName() {
    	return this.fullName;
    }
    
    @Override
	public String getUsername() {
		return this.username;
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
        if (intelligence > MAX_STAT_POINTS) {
            this.intelligence = MAX_STAT_POINTS;
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
        if (knowledge > MAX_STAT_POINTS) {
            this.knowledge = MAX_STAT_POINTS;
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
        if (vitality > MAX_STAT_POINTS) {
            this.vitality = MAX_STAT_POINTS;
            return;
        }
        if (vitality < 0) {
            this.vitality = 0;
            return;
        }
        this.vitality = vitality;
    }

    @Override
    public Rectangle getCollideBox() {
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

        boolean isMoving = this.isMovingDown || this.isMovingUp ||
        		this.isMovingRight || this.isMovingLeft;
        
        if (isMoving) {
        	this.col++;
        	this.col = (this.col) % IMAGES_COUNT_IN_PICTURE;

            if (this.isMovingLeft) {
            	this.row = SECOND_ROW;
            } else if (this.isMovingRight) {
            	this.row = THIRD_ROW;
            } else if (this.isMovingUp) {
            	this.row = FOURTH_ROW;
            } else if (this.isMovingDown) {
            	this.row = FIRST_ROW;
            }
        } else {
        	this.row = FIRST_ROW;
        	this.col = SECOND_ROW;
        }
        
        this.getCollideBox().setBounds(this.getX(), this.getY(),
                this.width, this.height);
        move();
    }

    @Override
    public int calculateGrade() {
        int grade;
        int ratio = (this.getKnowledge() + this.getVitality() + this.getIntelligence()) / STATISTICS_COUNT;

        if (ratio >= FAILURE.getMinRate() && ratio <= FAILURE.getMaxRate()) {
            grade = FAILURE.getGrade();
        } else if (ratio > PASSABLE.getMinRate() && ratio <= PASSABLE.getMaxRate()) {
            grade = PASSABLE.getGrade();
        } else if (ratio > GOOD.getMinRate() && ratio <= GOOD.getMaxRate()) {
            grade = GOOD.getGrade();
        } else if (ratio > VERY_GOOD.getMinRate() && ratio <= VERY_GOOD.getMaxRate()) {
            grade = VERY_GOOD.getGrade();
        } else {
            grade = EXCELLENT.getGrade();
        }

        return grade;
    }

    @Override
    public void addScore(int grade, ProgrammingLanguage language) {
        
        if (!this.studentGrades.containsKey(language.getProgrammingLanguageType().getName())) {
            this.studentGrades.put(language.getProgrammingLanguageType().getName(), new ArrayList<>());
        }

        this.studentGrades.get(language.getProgrammingLanguageType().getName()).add(grade);
    }

    @Override
    public void setStatsValues(int grade, ProgrammingLanguage language) {
        Grades gradeAsEnum =
                Arrays.stream(Grades.values())
                        .filter(g -> g.getGrade() == grade)
                        .findFirst()
                        .get();

        this.setKnowledge(
                this.getKnowledge() +
                (int) (language.getKnowledgePoints() *
                gradeAsEnum.getFactor()));

        int vitality = this.getVitality() - language.getVitalityDamagePoints();
        this.setVitality(vitality);
    }

    @Override
    public void getExhausted() {
        this.setVitality(this.getVitality() - 1);
    }

    private void move() {
        if (isMovingRight && this.getX() + DEFAULT_SPEED <= MAX_RIGHT_POSITION) {
            this.setX(this.getX() + DEFAULT_SPEED);
        }
        if (isMovingLeft && this.getX() + DEFAULT_SPEED >= MAX_LEFT_POSITION) {
            this.setX(this.getX() - DEFAULT_SPEED);
        }
        if (isMovingDown && this.getY() + DEFAULT_SPEED < MAX_DOWN_POSITION) {
            this.setY(this.getY() + DEFAULT_SPEED);
        }
        if (isMovingUp && this.getY() - DEFAULT_SPEED >= MAX_UP_POSITION) {
            this.setY(this.getY() - DEFAULT_SPEED);
        }
    }
}