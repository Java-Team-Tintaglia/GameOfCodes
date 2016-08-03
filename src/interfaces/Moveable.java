package interfaces;
/*
* <summary>
* 	This interface defines the behaviour for the movement of the characters.
* </summary>
* */

public interface Moveable {

    /*
       * <summary>
       *     This method is used to show the way of the object movements.
       * </summary>
       * <parameters>
       * 	<param type='boolean'>isMovingLeft</param>
       * 	<param type='boolean'>isMovingRight</param>
       * 	<param type='boolean'>isMovingUp</param>
       * 	<param type='boolean'>isMovingDown</param>
       * </parameters>
       * */


    /*
 * <summary>
 *     A method that moves the object to the left.
 * </summary>
 * <returns>
 * 	Returns a boolean indicating if the object moved to the left.
 * </returns>
 * */
    boolean isMovingLeft();

    void setMovingLeft(boolean isMovingLeft);
     /*
    * <summary>
    *      A method that moves the object to the right.
    * </summary>
    * <returns>
    * 	Returns a boolean indicating if the object moved to the right.
    * </returns>
    * */

    boolean isMovingRight();

    void setMovingRight(boolean isMovingRight);
    /*
     * <summary>
     *      A method that moves the object up.
     * </summary>
     * <returns>
     * 	Returns a boolean indicating if the object moved up.
     * </returns>
     * */
    boolean isMovingUp();

    void setMovingUp(boolean isMovingUp);
    /*
     * <summary>
     *      A method that moves the object down.
     * </summary>
     * <returns>
     * 	Returns a boolean indicating if the object moved down.
     * </returns>
     * */
    boolean isMovingDown();

    void setMovingDown(boolean isMovingDown);
}

