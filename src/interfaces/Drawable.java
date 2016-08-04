package interfaces;

import java.awt.*;

/**
 * This interface defines the behavior of the objects that will be drawn on the graphical interface.
 */
public interface Drawable {
   
	/**
     * This method is used to draw on the graphical interface.
     * @param graphics - the graphics that will be drawn.
     */
    void draw(Graphics graphics);

}

