package states;

import core.CollisionHandler;
import core.MapInitializor;
import enums.StudentType;
import factories.StudentFactory;
import graphics.Assets;
import models.programmingLanguages.ProgrammingLanguage;
import models.students.Student;
import models.wizards.Wizard;
import utils.Constants;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import authentication.AuthenticationProvider;

public class GameState extends State {
	
    private List<ProgrammingLanguage> programmingLanguages = new ArrayList<>();
    private Wizard wizard;
    
    private long timerNewWizard = System.nanoTime();
	private long timerNewProgrammingLanguage = System.nanoTime();
	private long timeDelayNewWizard = 3000;
	private long timeDelayNewProgrammingLanguage = 2000;
	private long timerSeconds = System.nanoTime();
	private long timeDelay = 1000;
	private int seconds = 30;

	public static Student student;
    private StudentFactory studentFactory;
 
    public GameState(StudentType studentType) {
		studentFactory = new StudentFactory();
		student = studentFactory.create(studentType, 
				Constants.DEFAUL_PLAYER_X_COORD, 
				Constants.DEFAUL_PLAYER_Y_COORD, 
				AuthenticationProvider.currentUser.getUsername());
		programmingLanguages.add(MapInitializor.generateProgrammingLanguage());
		wizard = MapInitializor.generateWizard();
	}


	@Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.wallToolbar, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.drawImage(Assets.floor, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);

		Font secondsFont = new Font("Comic Sans MS", Font.BOLD, 20);
		graphics.setFont(secondsFont);
		graphics.setColor(Color.yellow);

		graphics.drawString(Integer.toString(student.getVitality()), 80, 35);
		graphics.drawString(Integer.toString(student.getKnowledge()), 250, 35);
		graphics.drawString(Integer.toString(student.getIntelligence()), 455, 35);

		student.draw(graphics);
        
        if (!programmingLanguages.isEmpty()) {
        	 for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
             	programmingLanguage.draw(graphics);
     		}
		}
       
       
        if (wizard != null) {
        	wizard.draw(graphics);
		}

		graphics.drawString(Integer.toString(seconds), 950, 35);
    }

    @Override
    public void update() {
		
    	long elapsedNewWizard = (System.nanoTime() - this.timerNewWizard) / 1000000;
		long elapsedNewProgrammingLanguage = (System.nanoTime() - this.timerNewProgrammingLanguage) / 1000000;
		long elapsedSeconds = (System.nanoTime() - this.timerSeconds) / 1000000;
		
    	CollisionHandler.handleCollisions(student, wizard, programmingLanguages);
    	
		if(elapsedSeconds > this.timeDelay) {
			seconds--;
			timerSeconds = System.nanoTime();
		}
    	
        if (elapsedNewWizard > this.timeDelayNewWizard) {
        	wizard.setExist(false);
			wizard = MapInitializor.generateWizard();
			timerNewWizard = System.nanoTime();
		}
    	
        if (elapsedNewProgrammingLanguage > this.timeDelayNewProgrammingLanguage) {
			programmingLanguages.add(MapInitializor.generateProgrammingLanguage());
			timerNewProgrammingLanguage = System.nanoTime();
		}
    	
        if (seconds <= 0) {
			StateManager.setCurrentState(new StudentScoreState(student));
		}
        
        student.update();
    }
}
