package models.wizards;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import enums.WizardType;
import graphics.Assets;
import models.GameObject;
import models.students.Student;

public abstract class Wizard extends GameObject {
	
	private BufferedImage image;
	
    private WizardType wizardType;

	private Rectangle colliderBox;

    public Wizard(int x, int y, WizardType wizardType) {
    	super(x, y);
        this.wizardType = wizardType;
        this.image = Assets.wizard;
        this.colliderBox = new Rectangle(this.getX(), this.getY(),
                this.image.getWidth(), this.image.getHeight());
    }

    
    public Rectangle getColliderBox() {
        return colliderBox;
    }

    public abstract void boost(Student student);
    
    @Override
	public void draw(Graphics graphics) {
    	 graphics.drawImage(this.image, this.getX(), this.getY(), null);
		
	}

	@Override
	public void update() {	
	}
}
