package core;


import graphics.Display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputeHandler  implements KeyListener{

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
        }
        if (keyCode == KeyEvent.VK_DOWN) {
        }
        if (keyCode == KeyEvent.VK_LEFT) {
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
        }
        if (keyCode == KeyEvent.VK_DOWN) {
        }
        if (keyCode == KeyEvent.VK_LEFT) {
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
        }
    }
}
