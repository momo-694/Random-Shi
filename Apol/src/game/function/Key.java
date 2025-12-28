package game.function;

import game.entity.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener {
    public boolean pressedUp, pressedDown, pressedLeft, pressedRight;

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            pressedUp = true;
        }else if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            pressedDown = true;
        }else if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            pressedLeft = true;
        }else if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            pressedRight = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            pressedUp = false;
        }else if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            pressedDown = false;
        }else if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            pressedLeft = false;
        }else if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            pressedRight = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
