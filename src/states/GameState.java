package states;

import authentication.AuthenticationProvider;
import core.CollisionHandler;
import core.MapInitializor;
import enums.StudentType;
import factories.StudentFactory;
import graphics.Assets;
import interfaces.Student;
import interfaces.Wizard;
import models.programmingLanguages.ProgrammingLanguage;
import models.students.StudentImpl;
import utils.Constants;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
    private int i =0;
    private int j =4;
    private int height = 0;
    private int heightTwo = -300;
	private int secondsFontSize = 20;
	private int studentVitalityXCoord = 80;
	private int studentKnowledgeXCoord = 250;
	private int studentIntelligenceXCoord = 455;
	private int studentStatsYCoord = 35;
	private int secondsXCoord = 950;
	private int secondsYCoord = 35;

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


        graphics.drawImage(Assets.wall, 0, height-(height-i), Constants.SCREEN_WIDTH, 300, null);
        graphics.drawImage(Assets.wallTwo, 0, heightTwo-(height-j), Constants.SCREEN_WIDTH, 300, null);
		graphics.drawImage(Assets.wallToolbar, 0, 0, Constants.SCREEN_WIDTH, Constants.TOOLBAR_HEIGHT, null);
		graphics.drawImage(Assets.floor, 0, 295, Constants.SCREEN_WIDTH, Constants.FLOOR_HEIGHT, null);

		Font secondsFont = new Font("Comic Sans MS", Font.BOLD, secondsFontSize);
		graphics.setFont(secondsFont);
		graphics.setColor(Color.yellow);

		graphics.drawString(Integer.toString(student.getVitality()), studentVitalityXCoord, studentStatsYCoord);
		graphics.drawString(Integer.toString(student.getKnowledge()), studentKnowledgeXCoord, studentStatsYCoord);
		graphics.drawString(Integer.toString(student.getIntelligence()), studentIntelligenceXCoord, studentStatsYCoord);

		student.draw(graphics);
        
        if (!programmingLanguages.isEmpty()) {
        	 for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
             	programmingLanguage.draw(graphics);
     		}
		}
       
       
        if (wizard != null) {
        	wizard.draw(graphics);
		}

		graphics.drawString(Integer.toString(seconds), secondsXCoord, secondsYCoord);
    }

    @Override
    public void update() {

        i++;
        j++;

        if (i>=300){
            i=-296;
        }

        if(j>596){
            j=0;
        }
		
    	long elapsedNewWizard = (System.nanoTime() - this.timerNewWizard) / 1000000;
		long elapsedNewProgrammingLanguage = (System.nanoTime() - this.timerNewProgrammingLanguage) / 1000000;
		long elapsedSeconds = (System.nanoTime() - this.timerSeconds) / 1000000;
		
    	CollisionHandler.handleCollisions(student, wizard, programmingLanguages);
    	
		if(elapsedSeconds > this.timeDelay) {
			seconds--;
			student.getExhausted();
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
