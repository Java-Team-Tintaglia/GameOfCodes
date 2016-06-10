package models.programmingLanguages;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import enums.ProgrammingLanguageType;
import models.GameObject;

public abstract class ProgrammingLanguage extends GameObject {
	
	private ProgrammingLanguageType programmingLanguageType;
	
	private int vitalityDamagePoints;
	
	private int knowledgePoints;
	
	private BufferedImage image;

	public ProgrammingLanguage(int x, int y, 
			ProgrammingLanguageType programmingLanguageType, 
			int vitalityDamagePoints,
			int knowledgePoints,
			BufferedImage image) {
		super(x, y);
		this.programmingLanguageType = programmingLanguageType;
		this.vitalityDamagePoints = vitalityDamagePoints;
		this.knowledgePoints = knowledgePoints;
		this.image = image;
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
	
	@Override
	public void draw(Graphics graphics) {
		 graphics.drawImage(this.image, this.getX(), this.getY(), null);
		
	}

	@Override
	public void update() {
	}

}
