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
        boolean isShiftClicked = e.isShiftDown();
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
            if (!RegistrationFormState.isFieldSelected) {
                return;
            }
            String type = RegistrationFormState.fieldType;
            switch (type) {
                case "user":
                    if ((key >= KeyEvent.VK_0 && key <= KeyEvent.VK_9 ||
                            key >= KeyEvent.VK_A && key <= KeyEvent.VK_Z) && RegistrationFormState.username.length() < 15) {
                        RegistrationFormState.username.append((char) key);
                    } else if (key == KeyEvent.VK_BACK_SPACE && RegistrationFormState.username.length() > 0) {
                        RegistrationFormState.username.deleteCharAt(RegistrationFormState.username.length() - 1);
                    } else if (isShiftClicked && key == '-' && RegistrationFormState.username.length() < 15) {
                        RegistrationFormState.username.append("_");
                    }
                    break;
                case "first":
                    if ((key >= KeyEvent.VK_0 && key <= KeyEvent.VK_9 ||
                            key >= KeyEvent.VK_A && key <= KeyEvent.VK_Z) && RegistrationFormState.firstName.length() < 15) {
                        RegistrationFormState.firstName.append((char) key);
                    } else if (key == KeyEvent.VK_BACK_SPACE && RegistrationFormState.firstName.length() > 0) {
                        RegistrationFormState.firstName.deleteCharAt(RegistrationFormState.firstName.length() - 1);
                    } else if (isShiftClicked && key == '-' && RegistrationFormState.username.length() < 15) {
                        RegistrationFormState.firstName.append("_");
                    }
                    break;
                case "last":
                    if ((key >= KeyEvent.VK_0 && key <= KeyEvent.VK_9 ||
                            key >= KeyEvent.VK_A && key <= KeyEvent.VK_Z) && RegistrationFormState.lastName.length() < 15) {
                        RegistrationFormState.lastName.append((char) key);
                    } else if (key == KeyEvent.VK_BACK_SPACE && RegistrationFormState.lastName.length() > 0) {
                        RegistrationFormState.lastName.deleteCharAt(RegistrationFormState.lastName.length() - 1);
                    } else if (isShiftClicked && key == '-' && RegistrationFormState.username.length() < 15) {
                        RegistrationFormState.lastName.append("_");
                    }
                    break;
                case "pass":
                    if ((key >= KeyEvent.VK_0 && key <= KeyEvent.VK_9 ||
                            key >= KeyEvent.VK_A && key <= KeyEvent.VK_Z) && RegistrationFormState.password.length() < 15) {
                        RegistrationFormState.password.append((char) key);
                    } else if (key == KeyEvent.VK_BACK_SPACE && RegistrationFormState.password.length() > 0) {
                        RegistrationFormState.password.deleteCharAt(RegistrationFormState.password.length() - 1);
                    } else if (isShiftClicked && key == '-' && RegistrationFormState.username.length() < 15) {
                        RegistrationFormState.password.append("_");
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
