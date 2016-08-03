package interfaces;

import java.awt.*;

/**
 * This interface defines the behaviour for the objects that will be affected by unit collision.
 */

public interface Collidable {
    /**
     *  A method which is used to get the collision box for the colision check.
     *     @return the Rectangular box which is afterwards used to check the collision.
     */

    Rectangle getCollideBox();
}