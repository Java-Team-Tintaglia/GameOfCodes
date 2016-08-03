package states;

import constants.Coordinates;
import constants.Fonts;
import core.CollisionHandler;
import core.MapInitializor;
import enums.StudentType;
import factories.StudentFactoryImpl;
import graphics.Assets;
import interfaces.ProgrammingLanguage;
import interfaces.State;
import interfaces.Student;
import interfaces.StudentFactory;
import interfaces.Wizard;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameState implements State {
	
	private static final long TIME_DELAY_NEW_WIZARD = 3000;
	private static final long timeDelayNewProgrammingLanguage = 2000;
	private static final long timeDelay = 1000;
	private static final int STARTING_POSITION = 78;
	private static final int HEIGHT = 3;
	
	public static Student student;
    private List<ProgrammingLanguage> programmingLanguages = new ArrayList<>();
    private Wizard wizard;
    private StudentFactory studentFactory;
    private long timerNewWizard;
	private long timerNewProgrammingLanguage;
	private long timerSeconds;
	private int seconds = 30;
    
    private int step = STARTING_POSITION;
 
    public GameState(StudentType studentType, String username, String fullName) {
		this.studentFactory = new StudentFactoryImpl();
		
		student = this.studentFactory.create(studentType, 
				Coordinates.DEFAUL_PLAYER_X_COORD, 
				Coordinates.DEFAUL_PLAYER_Y_COORD, 
				username,
				fullName);
		
		this.programmingLanguages.add(MapInitializor.generateProgrammingLanguage());
		this.wizard = MapInitializor.generateWizard();
		this.timerNewWizard = System.nanoTime();
		this.timerNewProgrammingLanguage = System.nanoTime();
		this.timerSeconds = System.nanoTime();
	}

	@Override 
    public void draw(Graphics graphics) {
		int x = 0;
		int y = HEIGHT - (HEIGHT * this.step);
        graphics.drawImage(Assets.background, x, y, Coordinates.SCREEN_WIDTH, Coordinates.SCREEN_HEIGHT, null);
		
        graphics.drawImage(
        		Assets.wallToolbar, 
        		0, 
        		0, 
        		Coordinates.SCREEN_WIDTH, 
        		Coordinates.TOOLBAR_HEIGHT, 
        		null);
		
		graphics.drawImage(
				Assets.floor, 0, 
				Coordinates.GAME_STATE_FLOOR_Y, 
				Coordinates.SCREEN_WIDTH, 
				Coordinates.FLOOR_HEIGHT, 
				null);

		Font secondsFont = new Font(Fonts.COMIS_SANS_FONT, Font.BOLD, Fonts.TEXT_FONT_SIZE);
		graphics.setFont(secondsFont);
		graphics.setColor(Color.yellow);

		graphics.drawString(
				Integer.toString(student.getVitality()), 
				Coordinates.GAME_STATE_STUDENT_VITALITY_POINTS_X, 
				Coordinates.GAME_STATE_STUDENT_POINTS_Y);
		
		graphics.drawString(
				Integer.toString(student.getKnowledge()), 
				Coordinates.GAME_STATE_STUDENT_KNOWLEDGE_POINTS_X, 
				Coordinates.GAME_STATE_STUDENT_POINTS_Y);
		
		graphics.drawString(
				Integer.toString(student.getIntelligence()), 
				Coordinates.GAME_STATE_STUDENT_INTELLIGENCE_POINTS_X, 
				Coordinates.GAME_STATE_STUDENT_POINTS_Y);

		graphics.drawString(
				Integer.toString(this.seconds), 
				Coordinates.GAME_STATE_TIMER_X, 
				Coordinates.GAME_STATE_TIMER_Y);
		
		student.draw(graphics);
        
        if (!this.programmingLanguages.isEmpty()) {
        	 for (ProgrammingLanguage programmingLanguage : this.programmingLanguages) {
        		 programmingLanguage.draw(graphics);
     		}
		}
       
        if (this.wizard != null) {
        	this.wizard.draw(graphics);
		}
    }

    @Override
    public void update() {

    	this.step--;
    	
    	if (this.step <= 1) {
    		this.step = STARTING_POSITION;
		}
    	
        CollisionHandler.handleCollisions(student, wizard, programmingLanguages);
        
    	long elapsedNewWizard = (System.nanoTime() - this.timerNewWizard) / 1_000_000;
		long elapsedNewProgrammingLanguage = (System.nanoTime() - this.timerNewProgrammingLanguage) / 1_000_000;
		long elapsedSeconds = (System.nanoTime() - this.timerSeconds) / 1_000_000;

		if(elapsedSeconds > timeDelay) {
			this.seconds--;
			student.getExhausted();
			this.timerSeconds = System.nanoTime();
		}
    	
        if (elapsedNewWizard > TIME_DELAY_NEW_WIZARD) {
        	this.wizard.setExist(false);
			this.wizard = MapInitializor.generateWizard();
			this.timerNewWizard = System.nanoTime();
		}
    	
        if (elapsedNewProgrammingLanguage > timeDelayNewProgrammingLanguage) {
        	this.programmingLanguages.add(MapInitializor.generateProgrammingLanguage());
			this.timerNewProgrammingLanguage = System.nanoTime();
		}
    	
        if (this.seconds <= 0) {
			StateManager.setCurrentState(new StudentScoreState(student));
		}
        
        student.update();
    }
}
