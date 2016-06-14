package eventhandler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import enums.StudentType;
import graphics.Display;
import states.GameState;
import states.MainMenuState;
import states.PlayerCustomizationState;
import states.ScoresState;
import states.StateManager;


public class MouseInput implements MouseListener {
	private Display display;

    public MouseInput(Display display) {
        display.getCanvas().addMouseListener(this);
        this.display = display;    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {

        int mouseX = e.getX();
        int mouseY = e.getY();

        if(StateManager.getCurrentState() instanceof MainMenuState) {
            // Play Button
        	if(MainMenuState.buttonStart.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new PlayerCustomizationState());
            }

            // High Scores Button
            if (MainMenuState.buttonScore.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new ScoresState());
            }
            
            // Exit Button
            if (MainMenuState.buttonExit.getColliderBox().contains(mouseX, mouseY)) {
                System.exit(0);
            }
            
        } else if (StateManager.getCurrentState() instanceof PlayerCustomizationState) {
            
            if (PlayerCustomizationState.badBoyButton.getColliderBox().contains(mouseX, mouseY)) {
                PlayerCustomizationState.studentType = StudentType.BAD_BOY;
                PlayerCustomizationState.isSelect = true;
            } else if (PlayerCustomizationState.hotChickButton.getColliderBox().contains(mouseX, mouseY)) {
                PlayerCustomizationState.studentType = StudentType.HOT_CHICK;
                PlayerCustomizationState.isSelect = true;
            } else if (PlayerCustomizationState.nerdBoyButton.getColliderBox().contains(mouseX, mouseY)) {
                PlayerCustomizationState.studentType = StudentType.NERD_BOY;
                PlayerCustomizationState.isSelect = true;
            } else if (PlayerCustomizationState.nerdLadyButton.getColliderBox().contains(mouseX, mouseY)) {
                PlayerCustomizationState.studentType = StudentType.NERD_LADY;
                PlayerCustomizationState.isSelect = true;
            }
        	
        	// Select player and enter a name 
        	if(PlayerCustomizationState.playButton.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new GameState()); // TODO: change GameState(StudentType studentType, String name)
                
                PlayerCustomizationState.stringBuilger.setLength(0);
                
            }
        } else if (StateManager.getCurrentState() instanceof ScoresState) {
        	if (ScoresState.backToMenuButton.getColliderBox().contains(mouseX, mouseY)) {
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
