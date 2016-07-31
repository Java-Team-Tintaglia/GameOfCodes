package interfaces;

import java.awt.*;

/**
 * Created by PetyoPetrov on 31.07.2016 г..
 */
public interface GameObject extends Updatable,Drawable{
    public int getX();

    public void setX(int x);

    public int getY();

    public void setY(int y);

//    public abstract void draw(Graphics graphics);
//
//    public abstract void update();
}
