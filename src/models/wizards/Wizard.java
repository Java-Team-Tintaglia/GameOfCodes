package models.wizards;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import enums.WizardType;
import models.GameObject;
import models.students.Student;

public abstract class Wizard extends GameObject {

    private BufferedImage image;

    private WizardType wizardType;

    private Rectangle colliderBox;

    private boolean exist;

    public Wizard(int x, int y, WizardType wizardType, BufferedImage image ) {
        super(x, y);
        this.exist = true;
        this.wizardType = wizardType;
        this.image = image;
        this.colliderBox = new Rectangle(this.getX(), this.getY(),
                this.image.getWidth(), this.image.getHeight());
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public Rectangle getColliderBox() {
        return colliderBox;
    }
    
    public WizardType getWizardType() {
		return wizardType;
	}

	public abstract void boost(Student student);

    @Override
    public void draw(Graphics graphics) {
        if(this.exist) {
            graphics.drawImage(this.image, this.getX(), this.getY(), null);
        }

    }

    @Override
    public void update() {
    }


}
