package models.programmingLanguages;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import enums.ProgrammingLanguageType;
import models.GameObject;
import utils.RandomGenerator;

public abstract class ProgrammingLanguage extends GameObject {
	
	private ProgrammingLanguageType programmingLanguageType;
	private int vitalityDamagePoints;
	private int knowledgePoints;
	private BufferedImage image;
	private Rectangle colliderBox;
	private boolean exist;
	private boolean isOnFloor;

	public ProgrammingLanguage(int x, int y,
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
		this.isOnFloor = false;
	}

	public boolean isExist() {
		return exist;
	}

	public void setExist(boolean exist) {

		this.exist = exist;
	}

	public ProgrammingLanguageType getProgrammingLanguageType() {
		return programmingLanguageType;
	}

	public int getVitalityDamagePoints() {
		return vitalityDamagePoints;
	}

	public int getKnowledgePoints() {
		return knowledgePoints;
	}

	public void setKnowledgePoints(int knowledgePoints) {
		this.knowledgePoints = knowledgePoints;
	}
	
 	public Rectangle getColliderBox() {
	        return colliderBox;
	    }
	
	@Override
	public void draw(Graphics graphics) {
		if(exist) {
			graphics.drawImage(this.image, this.getX(), this.getY(), null);
			//
			int randomY = RandomGenerator.genNextRandomMinMax(230, 515);
			int currentX = this.getX();
			int currentY = this.getY();
			int currentWidth = (int) this.colliderBox.getWidth();
			int currentHeight = (int) this.colliderBox.getHeight();
			while(!this.isOnFloor){
				this.setY(currentY += 5);
				graphics.drawImage(this.image, this.getX(), this.getY(), null);
				if(currentY > randomY){
					this.isOnFloor = true;
				}
			}
			this.colliderBox.setBounds(currentX, currentY,
					currentWidth, currentHeight);
		}
	}

	@Override
	public void update() {
	}
}
