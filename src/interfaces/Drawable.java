package interfaces;

import java.awt.*;
/*
* <summary>
*     This interface defines the behaviour of the objects that will be drawen on the graphical interface.
* </summary>
* */


public interface Drawable {
    	/*
	* <summary>
	*     This method is used to draw on the graphical interface.
	* </summary>
	* <parameters>
	* 	<param type='Graphics'>graphics</param>
	* </parameters>
	* */

    void draw(Graphics graphics);

}

