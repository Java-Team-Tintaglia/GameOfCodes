package interfaces;

import java.awt.*;
/*
* <summary>
*This interface defines the behaviour for the objects that will be affected by unit collision.
* </summary>
* */

public interface Collidable {
    	/*
	* <summary>]
	*       A method which is used to get the collision box for the colision check.
	* </summary>
	* <returns>
	*     Returns the Rectangular box which is afterwards used to check the collision.
	* </returns>
	* */

    Rectangle getCollideBox();
}