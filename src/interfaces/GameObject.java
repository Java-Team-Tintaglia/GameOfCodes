package interfaces;

/**
 * This interface defines the basic functionality for every game object.
 */
public interface GameObject extends Updatable, Drawable{
    
	/**
     * This method gets the x coordinate of the current object.
     * @return  an Integer indicating the x coordinate of the current object.
     */
    public int getX();

    /**
     * This method is used to set parameter x coordinate of the current object.
     * @param x coordinate of the current object.
     */
    public void setX(int x);

    /**
     * gets the y coordinate of the current object.
     * @return an Integer indicating the y coordinate of the current object.
     */
    public int getY();


    /**
     * This method is used to set parameter y coordinate of the current object.
     * @param y coordinate of the current object.
     */
    public void setY(int y);

}
