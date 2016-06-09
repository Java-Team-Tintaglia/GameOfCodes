package eventhandler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import graphics.Display;
import states.GameState;
import states.MainMenuState;
import states.PlayerCustomizationState;
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
        	if(MainMenuState.buttonPlay.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new PlayerCustomizationState());
            }

            // High Scores Button
//            if (MainMenuState.scoresButton.getColliderBox().contains(mouseX, mouseY)) {
//                StateManager.setCurrentState(new HighScoresState());
//            }
            
            // Exit Button
            if (MainMenuState.buttonExit.getColliderBox().contains(mouseX, mouseY)) {
                System.exit(0);
            }
            
        } else if (StateManager.getCurrentState() instanceof PlayerCustomizationState) {
        	
        	// Select player and enter a name 
        	if(PlayerCustomizationState.playButton.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new GameState()); // TODO: Add Player in constructur
                
                PlayerCustomizationState.stringBuilger.setLength(0);
                
            }
        }
//        } else if (StateManager.getCurrentState() instanceof HighScoresState) {
//        	// Main menu button 
//        }
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
