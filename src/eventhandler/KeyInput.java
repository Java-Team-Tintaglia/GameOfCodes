package eventhandler;

import core.GameEngine;
import graphics.Display;
import states.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    GameEngine gameEngine;

    public KeyInput(GameEngine gameengine, Display display) {
        this.gameEngine = gameengine;
        display.getCanvas().addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        boolean isShiftClicked = e.isShiftDown();
        		
        if (StateManager.getCurrentState() instanceof GameState) {

             int keyCode = e.getKeyCode();

             if (keyCode == KeyEvent.VK_UP) {
                 GameState.student.setMovingUp(true);
             }

             if (keyCode == KeyEvent.VK_DOWN) {
                 GameState.student.setMovingDown(true);
             }

             if (keyCode == KeyEvent.VK_LEFT) {
                 GameState.student.setMovingLeft(true);
             }

             if (keyCode == KeyEvent.VK_RIGHT) {
                 GameState.student.setMovingRight(true);
             }
        } else if (StateManager.getCurrentState() instanceof RegistrationFormState) {
            String type = RegistrationFormState.fieldType;
            switch (type) {
                case "user":
				generateKeywords(key, isShiftClicked, RegistrationFormState.username, false);
                    break;
                case "first":
                	generateKeywords(key, isShiftClicked, RegistrationFormState.firstName, true);
                    break;
                case "last":
                	generateKeywords(key, isShiftClicked, RegistrationFormState.lastName, true);
                    break;
                case "pass":
                	generateKeywords(key, isShiftClicked, RegistrationFormState.password, false);
                    break;
            	}
            } else if (StateManager.getCurrentState() instanceof LoginFormState) {
                String type = LoginFormState.fieldType;
                switch (type) {
                    case "user":
                    	generateKeywords(key, isShiftClicked, LoginFormState.username, false);
                        break;
                    case "pass":
                    	generateKeywords(key, isShiftClicked, LoginFormState.password, false);
                        break;
                }
        } else if (StateManager.getCurrentState() instanceof EditProfileState) {
            String type = EditProfileState.fieldType;
            switch (type) {
                case "first":
                	generateKeywords(key, isShiftClicked, EditProfileState.firstName, true);
                    break;
                case "last":
                	generateKeywords(key, isShiftClicked, EditProfileState.lastName, true);
                    break;
                case "pass":
                	generateKeywords(key, isShiftClicked, EditProfileState.password, false);
                    break;
            }
        }
    }

	
    @Override
    public void keyReleased(KeyEvent e) {
    	if (StateManager.getCurrentState() instanceof GameState) {
	    	 int keyCode = e.getKeyCode();
	    	 
	         if (keyCode == KeyEvent.VK_UP) {
	             GameState.student.setMovingUp(false);
	         }
	         
	         if (keyCode == KeyEvent.VK_DOWN) {
	             GameState.student.setMovingDown(false);
	         }
	         
	         if (keyCode == KeyEvent.VK_LEFT) {
	             GameState.student.setMovingLeft(false);
	         }
	         
	         if (keyCode == KeyEvent.VK_RIGHT) {
	             GameState.student.setMovingRight(false);
	         }
    	}
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    private void generateKeywords(int key, boolean isShiftClicked, StringBuilder ouput, boolean isName) {
		if ((key >= KeyEvent.VK_0 && key <= KeyEvent.VK_9 ||
		        key >= KeyEvent.VK_A && key <= KeyEvent.VK_Z) && ouput.length() < 15) {
			ouput.append((char) key);
		} else if (key == KeyEvent.VK_BACK_SPACE && ouput.length() > 0) {
			ouput.deleteCharAt(ouput.length() - 1);
		} else if (!isName && isShiftClicked && key == '-' && ouput.length() < 15) {
			ouput.append("_");
		}
	}
}
