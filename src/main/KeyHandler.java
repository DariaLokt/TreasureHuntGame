package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, rightPressed, leftPressed = false;
    public boolean upReleased, downReleased, rightReleased, leftReleased;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upReleased = true;
            upPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftReleased = true;
            leftPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downReleased = true;
            downPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightReleased = true;
            rightPressed = false;
        }
    }
}
