package eventhandler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Map.Entry;

import enums.StudentType;
import graphics.Display;
import repositories.StudentScoresRepository;
import states.GameState;
import states.MainMenuState;
import states.PlayerCustomizationState;
import states.ScoresState;
import states.StateManager;
import states.StudentScoreState;


public class MouseInput implements MouseListener {
	private Display display;

    public MouseInput(Display display) {
        display.getCanvas().addMouseListener(this);
        this.display = display;    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        int mouseX = e.getX();
        int mouseY = e.getY();

        if(StateManager.getCurrentState() instanceof MainMenuState) {
            // Play Button
        	if(MainMenuState.buttonStart.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new PlayerCustomizationState());
            }

            // Scores Button
            if (MainMenuState.buttonScore.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new ScoresState());
            }
            
            // Exit Button
            if (MainMenuState.buttonExit.getColliderBox().contains(mouseX, mouseY)) {
                System.exit(0);
            }
            
        } else if (StateManager.getCurrentState() instanceof PlayerCustomizationState) {
            
        	// Select player
            if (PlayerCustomizationState.badBoyButton.getColliderBox().contains(mouseX, mouseY)) {
                PlayerCustomizationState.studentType = StudentType.BAD_BOY;
                PlayerCustomizationState.isSelected = true;
            } else if (PlayerCustomizationState.hotChickButton.getColliderBox().contains(mouseX, mouseY)) {
                PlayerCustomizationState.studentType = StudentType.HOT_CHICK;
                PlayerCustomizationState.isSelected = true;
            } else if (PlayerCustomizationState.nerdBoyButton.getColliderBox().contains(mouseX, mouseY)) {
                PlayerCustomizationState.studentType = StudentType.NERD_BOY;
                PlayerCustomizationState.isSelected = true;
            } else if (PlayerCustomizationState.nerdLadyButton.getColliderBox().contains(mouseX, mouseY)) {
                PlayerCustomizationState.studentType = StudentType.NERD_LADY;
                PlayerCustomizationState.isSelected = true;
            }
        	
        	// Eenter a name 
        	if (PlayerCustomizationState.playButton.getColliderBox().contains(mouseX, mouseY)) {
        		String name = PlayerCustomizationState.stringBuilger.toString();
        		StudentType type = PlayerCustomizationState.studentType;
                StateManager.setCurrentState(new GameState(type, name));
                
                PlayerCustomizationState.stringBuilger.setLength(0);
                PlayerCustomizationState.isSelected = false;
                
            }
        } else if (StateManager.getCurrentState() instanceof ScoresState) {
        	if (ScoresState.backToMenuButton.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new MainMenuState());
            }
        } else if (StateManager.getCurrentState() instanceof StudentScoreState) {
        	if (StudentScoreState.backToMenuButton.getColliderBox().contains(mouseX, mouseY)) {
        		StudentScoreState studentScoreState = (StudentScoreState)StateManager.getCurrentState();
        		String studentName = studentScoreState.getStudent().getName();
        		
        		for (Entry<String, List<Integer>> score : studentScoreState.getStudent().getStudentGrades().entrySet()) {
        			StudentScoresRepository.saveToFile(studentName, score.getKey(), score.getValue());
				}
        		
                StateManager.setCurrentState(new MainMenuState());
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
