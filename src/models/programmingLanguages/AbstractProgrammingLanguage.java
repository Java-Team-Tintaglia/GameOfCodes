package models.programmingLanguages;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import enums.ProgrammingLanguageType;
import interfaces.ProgrammingLanguage;
import models.AbstractGameObject;

public abstract class AbstractProgrammingLanguage extends AbstractGameObject implements ProgrammingLanguage {
	
	private ProgrammingLanguageType programmingLanguageType;
	private int vitalityDamagePoints;
	private int knowledgePoints;
	private BufferedImage image;
	private Rectangle colliderBox;
	private boolean exist;

	public AbstractProgrammingLanguage(int x, int y,
							   ProgrammingLanguageType programmingLanguageType,
							   int vitalityDamagePoints,
							   int knowledgePoints,
							   BufferedImage image) {
		super(x, y);
		this.exist = true;
		this.programmingLanguageType = programmingLanguageType;
		this.vitalityDamagePoints = vitalityDamagePoints;
		this.knowledgePoints = knowledgePoints;
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
	public ProgrammingLanguageType getProgrammingLanguageType() {
		return programmingLanguageType;
	}

	@Override
	public int getVitalityDamagePoints() {
		return vitalityDamagePoints;
	}

	@Override
	public int getKnowledgePoints() {
		return knowledgePoints;
	}
	
	@Override
 	public Rectangle getColliderBox() {
	        return colliderBox;
	    }
	
	@Override
	public void draw(Graphics graphics) {
		if(exist) {
			graphics.drawImage(this.image, this.getX(), this.getY(), null);
		}
	}

	@Override
	public void update() {
	}
}
