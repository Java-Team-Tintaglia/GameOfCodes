package interfaces;

import java.awt.*;

/**
 * This interface defines the behavior for the objects that will be affected by unit collision.
 */
public interface Collidable {
    
	/**
     *  A method which is used to get the collision box for the collision check.
     *     @return the Rectangular box which is used to check the collision.
     */
    Rectangle getCollideBox();
}