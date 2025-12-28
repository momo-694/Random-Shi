package map;

import game.screen.MainPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Tiler {
    private List<Tiles> tile;
    private MainPanel mp;
    private int[][] mapTiles;

    public Tiler(MainPanel mp) {
        this.mp = mp;
        mapTiles = new int[mp.screenRow][mp.screenCol];
        tile = new ArrayList<Tiles>();

        loadSprites();
        loadMap();
    }

    public void loadSprites() {
        tile.add(new Tiles("grass.png"));
        tile.add(new Tiles("water.png"));
    }

    public void loadMap() {
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/maps/map.txt")));
            String line;

            for(int i = 0; i < mp.screenRow; i++) {
                line = rd.readLine();
                for(int k = 0; k < mp.screenCol; k++) {
                    String[] num = line.split(" ");
                    int number = Integer.parseInt(num[k]);
                    mapTiles[i][k] = number;
                }
            }
            rd.close();
        }catch(Exception e) {
            throw new IllegalArgumentException("Error occurred while loading map.");
        }
    }

    public void draw(Graphics2D g2) {
        for(int i = 0; i < mp.screenCol; i++) {
            for(int k = 0; k < mp.screenRow; k++) {
                g2.drawImage(tile.get(mapTiles[k][i]).sprite, i*mp.tileSize, k* mp.tileSize, mp.tileSize, mp.tileSize, null);
            }
        }
    }
}
