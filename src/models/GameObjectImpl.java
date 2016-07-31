package models;

import interfaces.Drawable;
import interfaces.GameObject;
import interfaces.Updatable;

import java.awt.*;

public abstract class GameObjectImpl implements GameObject{

    private int x;
    private int y;


    public GameObjectImpl(int x, int y) {
        this.x = x;
        this.y = y;

    }

    protected GameObjectImpl() {
    }
    @Override
    public int getX() {
        return x;
    }
    @Override
    public void setX(int x) {
        this.x = x;
    }
    @Override
    public int getY() {
        return y;
    }
    @Override
    public void setY(int y) {
        this.y = y;
    }
    @Override
    public abstract void draw(Graphics graphics);
    @Override
    public abstract void update();

}
