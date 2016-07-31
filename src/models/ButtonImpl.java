package models;

import interfaces.Button;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ButtonImpl extends AbstractGameObject implements Button{
    
	private Rectangle colliderBox;
    private BufferedImage gameObjectIcon;

    public ButtonImpl(int x, int y, BufferedImage gameObjectIcon) {
        super(x, y);
        this.gameObjectIcon = gameObjectIcon;
        this.colliderBox = new Rectangle(this.getX(), this.getY(),
                this.gameObjectIcon.getWidth(), this.gameObjectIcon.getHeight());
    }
    
    @Override
    public Rectangle getColliderBox() {
        return this.colliderBox;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(this.gameObjectIcon, this.getX(), this.getY(), null);
    }

    @Override
    public void update() {
    }
}


