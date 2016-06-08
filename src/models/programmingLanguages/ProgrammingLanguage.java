package models.programmingLanguages;

import java.awt.Graphics;

import enums.ProgrammingLanguageType;
import models.GameObject;

public abstract class ProgrammingLanguage extends GameObject {
	
	private ProgrammingLanguageType programmingLanguageType;
	
	private int vitalityDamagePoints;
	
	private int knowledgePoints;

	public ProgrammingLanguage(int x, int y, 
			ProgrammingLanguageType programmingLanguageType, 
			int vitalityDamagePoints,
			int knowledgePoints) {
		super(x, y);
		this.programmingLanguageType = programmingLanguageType;
		this.vitalityDamagePoints = vitalityDamagePoints;
		this.knowledgePoints = knowledgePoints;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
