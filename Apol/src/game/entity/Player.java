package game.entity;

import game.function.Key;
import game.screen.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Player extends Entity {
    private Image currentImg;
    private MainPanel mp;

    public Player(MainPanel mp) {
        x = 100;
        y = 100;
        speed = 3;
        direction = "down";
        this.mp = mp;

        loadSprites();
    }

    public void loadSprites() {
        try {
            standFront = ImageIO.read(getClass().getResourceAsStream("/player/front_stand.png"));
            standBack = ImageIO.read(getClass().getResourceAsStream("/player/back_stand.png"));
            standLeft = ImageIO.read(getClass().getResourceAsStream("/player/left_stand.png"));
            standRight = ImageIO.read(getClass().getResourceAsStream("/player/right_stand.png"));
            walkFront1 = ImageIO.read(getClass().getResourceAsStream("/player/front_walk1.png"));
            walkFront2 = ImageIO.read(getClass().getResourceAsStream("/player/front_walk2.png"));
            walkBack1 = ImageIO.read(getClass().getResourceAsStream("/player/back_walk1.png"));
            walkBack2 = ImageIO.read(getClass().getResourceAsStream("/player/back_walk2.png"));
            walkLeft1 = ImageIO.read(getClass().getResourceAsStream("/player/left_walk1.png"));
            walkLeft2 = ImageIO.read(getClass().getResourceAsStream("/player/left_walk2.png"));
            walkRight1 = ImageIO.read(getClass().getResourceAsStream("/player/right_walk1.png"));
            walkRight2 = ImageIO.read(getClass().getResourceAsStream("/player/right_walk2.png"));
        }catch(Exception e) {
            throw new IllegalArgumentException("Sprites did not load properly.");
        }
    }

    public void update(Key key) {
        if(key.pressedDown || key.pressedLeft || key.pressedUp || key.pressedRight) {
            if (key.pressedUp) {
                direction = "up";
                y -= speed;
            } else if (key.pressedDown) {
                direction = "down";
                y += speed;
            } else if (key.pressedLeft) {
                direction = "left";
                x -= speed;
            } else if (key.pressedRight) {
                direction = "right";
                x += speed;
            }
            spriteCounter++;

            spriteNumber = lastSpriteNumber;
            if (spriteCounter >= 12) {
                if (spriteNumber == 1) {
                    spriteNumber = 2;
                } else if (spriteNumber == 2) {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
                lastSpriteNumber = spriteNumber;
            }
        }else {
            spriteNumber = 0;
        }
    }


    public void draw(Graphics2D g2) {
        switch(direction) {
            case "up":
                if(spriteNumber == 0) {
                    currentImg = standBack;
                }else if(spriteNumber == 1) {
                    currentImg = walkBack1;
                }else if(spriteNumber == 2) {
                    currentImg = walkBack2;
                }
                break;
            case "down":
                if(spriteNumber == 0) {
                    currentImg = standFront;
                }else if(spriteNumber == 1) {
                    currentImg = walkFront1;
                }else if(spriteNumber == 2) {
                    currentImg = walkFront2;
                }
                break;
            case "left":
                if(spriteNumber == 0) {
                    currentImg = standLeft;
                }else if(spriteNumber == 1) {
                    currentImg = walkLeft1;
                }else if(spriteNumber == 2) {
                    currentImg = walkLeft2;
                }
                break;
            case "right":
                if(spriteNumber == 0) {
                    currentImg = standRight;
                }else if(spriteNumber == 1) {
                    currentImg = walkRight1;
                }else if(spriteNumber == 2) {
                    currentImg = walkRight2;
                }
                break;
        }
        g2.drawImage(currentImg, x, y, mp.tileSize, mp.tileSize, null);
    }
}
