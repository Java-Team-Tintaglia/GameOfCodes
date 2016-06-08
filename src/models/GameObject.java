package models;

import interfaces.Drawable;
import interfaces.Updatable;

import java.awt.*;

public abstract class GameObject implements Drawable, Updatable{

    private int x;
    private int y;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected GameObject() {
    }

    public int getX(){
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract void draw(Graphics graphics);

    public abstract void update();

}
