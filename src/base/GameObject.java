package base;

import interfaces.Drawable;
import interfaces.Updatable;

import java.awt.*;

/**
 * Created by soki on 05-Jun-16.
 */
public abstract class GameObject implements Drawable, Updatable{

    private int x;
    private int y;

    //constructor

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //getters and setters

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

    //methods
    public abstract void display (Graphics graphics);

    public abstract void update();

}
