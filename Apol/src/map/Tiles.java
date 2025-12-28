package map;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Tiles {
    public BufferedImage sprite;

    public Tiles(String img) {
        try {
            this.sprite = ImageIO.read(getClass().getResourceAsStream("/tiles/" + img));
        }catch(Exception e) {
            throw new IllegalArgumentException("Sprite did not load properly.");
        }
    }
}
