package interfaces;

/**
 * This interface defines the behaviour for the movement of the characters.
 */
public interface Moveable {
    /**
     * This method is used to show the way of the object movements.
     * @return a boolean indicating if the object moved to the left.
     */


    boolean isMovingLeft();

    /**
     * This method is used to show the way of the object movements.
     * @param  isMovingLeft - the way of the object movements.
     */
    void setMovingLeft(boolean isMovingLeft);

    /**
     * This method is used to show the way of the object movements.
     * @return a boolean indicating if the object moved to the right.
     */
    boolean isMovingRight();
    /**
     * This method is used to show the way of the object movements.
     * @param  isMovingRight - the way of the object movements.
     */
    void setMovingRight(boolean isMovingRight);
    /**
     * This method is used to show the way of the object movements.
     * @return a boolean indicating if the object moved up.
     */
    boolean isMovingUp();
    /**
     * This method is used to show the way of the object movements.
     * @param  isMovingUp - the way of the object movements.
     */
    void setMovingUp(boolean isMovingUp);
    /**
     * This method is used to show the way of the object movements.
     * @return a boolean indicating if the object moved to the down.
     */
    boolean isMovingDown();
    /**
     * This method is used to show the way of the object movements.
     * @param  isMovingDown - the way of the object movements.
     */
    void setMovingDown(boolean isMovingDown);
}

