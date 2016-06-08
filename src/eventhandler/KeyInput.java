package eventhandler;


import core.GameEngine;
import graphics.Display;
import states.PlayerCustomizationState;
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
        //if (StateManager.getCurrentState() instanceof PlayerCustomizationState) {
            if (key>='A' && key<='Z' ) {
                PlayerCustomizationState.stringBuilger.append((char) key);
            }
            else if (key == KeyEvent.VK_BACK_SPACE && PlayerCustomizationState.stringBuilger.length() > 0) {
                PlayerCustomizationState.stringBuilger.deleteCharAt(PlayerCustomizationState.stringBuilger.length() - 1);
            }
        //}
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

}
