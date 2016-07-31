package models.wizards;

import enums.WizardType;
import interfaces.Student;
import interfaces.Wizard;
import models.GameObjectImpl;
import models.students.StudentImpl;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class WizardImpl extends GameObjectImpl implements Wizard {

    private BufferedImage image;

    private WizardType wizardType;

    private Rectangle colliderBox;

    private boolean exist;

    public WizardImpl(int x, int y, WizardType wizardType, BufferedImage image ) {
        super(x, y);
        this.exist = true;
        this.wizardType = wizardType;
        this.image = image;
        this.colliderBox = new Rectangle(this.getX(), this.getY(),
                this.image.getWidth(), this.image.getHeight());
    }
    @Override
    public boolean isExist() {
        return exist;
    }
    @Override
    public void setExist(boolean exist) {
        this.exist = exist;
    }
    @Override
    public Rectangle getColliderBox() {
        return colliderBox;
    }
    @Override
    public WizardType getWizardType() {
		return wizardType;
	}
    @Override
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
