package game.screen;
import game.entity.*;
import game.function.Key;
import map.Tiler;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel implements Runnable {
    public final int screenRow = 8;
    public final int screenCol = 14;
    public final int tileSize = 16 * 5;
	final int screenWidth = screenCol * tileSize;
	final int screenHeight = screenRow * tileSize;
    final int FPS = 60;

    Thread thread;
    Player p1;
    Key key;
    Tiler tiler;

	public MainPanel() {
		setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBackground(Color.black);

        p1 = new Player(this);
        key = new Key();
        tiler = new Tiler(this);
        thread = new Thread(this);
        thread.start();

        addKeyListener(key);
        setFocusable(true);
	}

    @Override
    public void run() {
        double drawInterval = 1000000000.0/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int counter = 0;

        while(thread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
                counter++;
            }

            if(timer >= 1000000000) {
                System.out.println("FPS: " + counter);
                counter = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        p1.update(key);
    }

	@Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
        tiler.draw(g2);
        p1.draw(g2);
        g2.dispose();
	}
}