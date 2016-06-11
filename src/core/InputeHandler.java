package core;


import graphics.Display;
import models.students.Student;
import states.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputeHandler implements KeyListener {

    public InputeHandler(Display display) {
        display.getCanvas().addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            GameState.student.isMovingUp = true;

        }
        if (keyCode == KeyEvent.VK_DOWN) {
            GameState.student.isMovingDown = true;

        }
        if (keyCode == KeyEvent.VK_LEFT) {
            GameState.student.isMovingLeft = true;
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            GameState.student.isMovingRight = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            GameState.student.isMovingUp = false;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            GameState.student.isMovingDown = false;
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            GameState.student.isMovingLeft = false;
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            GameState.student.isMovingRight = false;
        }
    }
}
