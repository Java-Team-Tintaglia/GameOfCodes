package models;

import interfaces.Collidable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Button extends GameObjectImpl implements Collidable {
    private Rectangle colliderBox;
    private BufferedImage gameObjectIcon;

    public Button(int x, int y, BufferedImage gameObjectIcon) {
        super(x, y);
        this.gameObjectIcon = gameObjectIcon;
        this.colliderBox = new Rectangle(this.getX(), this.getY(),
                this.gameObjectIcon.getWidth(), this.gameObjectIcon.getHeight());
    }
    @Override
    public Rectangle getColliderBox() {
        return colliderBox;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(this.gameObjectIcon, this.getX(), this.getY(), null);
    }

    @Override
    public void update() {
    }
}


