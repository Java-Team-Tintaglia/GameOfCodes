package eventhandler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import enums.StudentType;
import graphics.Display;
import states.GameState;
import states.MainMenuState;
import states.PlayerCustomizationState;
import states.StateManager;

public class MouseInput implements MouseListener {
    private Display display;

    static StudentType chosenStudentType;

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

        if (StateManager.getCurrentState() instanceof MainMenuState) {
            // Play Button
            if (MainMenuState.buttonPlay.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new PlayerCustomizationState());
            }

            // High Scores Button
            // if (MainMenuState.scoresButton.getColliderBox().contains(mouseX,
            // mouseY)) {
            // StateManager.setCurrentState(new HighScoresState());
            // }

            // Exit Button
            if (MainMenuState.buttonExit.getColliderBox().contains(mouseX, mouseY)) {
                System.exit(0);
            }

        } else if (StateManager.getCurrentState() instanceof PlayerCustomizationState) {
            String studentName = "testName";
            if (PlayerCustomizationState.nerdLadyCharacter.getColliderBox().contains(mouseX, mouseY)) {
                chosenStudentType = StudentType.NerdLady;
            }
            if (PlayerCustomizationState.badBoyCharacter.getColliderBox().contains(mouseX, mouseY)) {
                chosenStudentType = StudentType.BadBoy;
            }
            if (PlayerCustomizationState.nerdBoyCharacter.getColliderBox().contains(mouseX, mouseY)) {
                chosenStudentType = StudentType.NerdBoy;
            }
            if (PlayerCustomizationState.hotGirlCharacter.getColliderBox().contains(mouseX, mouseY)) {
                chosenStudentType = StudentType.HotChick;
            }

            // TODO: set name
            // Select player and enter a name
            if (PlayerCustomizationState.playButton.getColliderBox().contains(mouseX, mouseY)) {
                if (chosenStudentType != null) {
                    StateManager.setCurrentState(new GameState(chosenStudentType, studentName, mouseX, mouseY));
                    PlayerCustomizationState.stringBuilger.setLength(0);
                }

            }
        }
        // } else if (StateManager.getCurrentState() instanceof HighScoresState)
        // {
        // // Main menu button
        // }
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
