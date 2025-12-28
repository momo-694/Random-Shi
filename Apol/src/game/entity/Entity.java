package game.entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    public int x;
    public int y;
    public int speed;
    public String direction;
    public BufferedImage standFront, standBack, standLeft, standRight, walkFront1, walkFront2, walkBack1, walkBack2, walkLeft1, walkLeft2, walkRight1, walkRight2;
    public int spriteCounter = 0, spriteNumber = 1, lastSpriteNumber = spriteNumber;
}
