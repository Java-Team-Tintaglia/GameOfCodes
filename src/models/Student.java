package models;

import com.sun.deploy.ui.ImageLoader;
import graphics.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by soki on 08-Jun-16.
 */
public abstract class Student extends GameObject{

    private int x;
    private int y;
    SpriteSheet spriteSheet;
    private String name;
    private int intelligence;
    private int knowledge;
    private int vitality;
    private Rectangle colliderBox;


    public Student(int x , int y,SpriteSheet spriteSheet,String name, int intelligence, int knowledge, int vitality) {
        this.x = x;
        this.y = y;
        this.spriteSheet = spriteSheet;
        this.name = name;
        this.intelligence = intelligence;
        this.knowledge = knowledge;
        this.vitality = vitality;
        this.colliderBox = new Rectangle(this.getX(), this.getY());
    }


    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getVitality(){
        return vitality;
    }
    public void setVitality(int vitality){
        this.vitality = vitality;
    }
    public int getKnowledge() {
        return knowledge;
    }
    public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

}
