package eventhandler;

import core.GameEngine;
import graphics.Display;
import states.GameState;
import states.PlayerCustomizationState;
import states.RegistrationFormState;
import states.StateManager;

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
        // User input
        if (StateManager.getCurrentState() instanceof PlayerCustomizationState) {
            if (key>='A' && key<='Z' && PlayerCustomizationState.stringBuilger.length() < 10) {
                PlayerCustomizationState.stringBuilger.append((char) key);
            }
            else if (key == KeyEvent.VK_BACK_SPACE && PlayerCustomizationState.stringBuilger.length() > 0) {
                PlayerCustomizationState.stringBuilger.deleteCharAt(PlayerCustomizationState.stringBuilger.length() - 1);
            }
        } else if (StateManager.getCurrentState() instanceof GameState) {
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
                    if (key>='A' && key<='Z' && RegistrationFormState.userString.length() < 15) {
                        RegistrationFormState.userString.append((char) key);
                    } else if (key == KeyEvent.VK_BACK_SPACE && RegistrationFormState.userString.length() > 0) {
                        RegistrationFormState.userString.deleteCharAt(RegistrationFormState.userString.length() - 1);
                    }
                    break;
                case "first":
                    if (key>='A' && key<='Z' && RegistrationFormState.firstString.length() < 15) {
                        RegistrationFormState.firstString.append((char) key);
                    } else if (key == KeyEvent.VK_BACK_SPACE && RegistrationFormState.firstString.length() > 0) {
                        RegistrationFormState.firstString.deleteCharAt(RegistrationFormState.firstString.length() - 1);
                    }
                    break;
                case "last":
                    if (key>='A' && key<='Z' && RegistrationFormState.lastString.length() < 15) {
                        RegistrationFormState.lastString.append((char) key);
                    } else if (key == KeyEvent.VK_BACK_SPACE && RegistrationFormState.lastString.length() > 0) {
                        RegistrationFormState.lastString.deleteCharAt(RegistrationFormState.lastString.length() - 1);
                    }
                    break;
                case "pass":
                    if (key>='A' && key<='Z' && RegistrationFormState.passString.length() < 15) {
                        RegistrationFormState.passString.append((char) key);
                    } else if (key == KeyEvent.VK_BACK_SPACE && RegistrationFormState.passString.length() > 0) {
                        RegistrationFormState.passString.deleteCharAt(RegistrationFormState.passString.length() - 1);
                    }
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

}
