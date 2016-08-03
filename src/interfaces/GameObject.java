package interfaces;


public interface GameObject extends Updatable, Drawable{
    /*
   * <summary>
   *    gets the x coordinate of the current object.
   * </summary>
   * <returns>
   * 	Returns an Integer indicating the x coordinate of the current object.
   * </returns>
   * */
    public int getX();

    /*
  * <summary>
  *     This method is used to set parameter x coordinate of the current object.
  * </summary>
  * <parameters>
  * 	<param type='int'>x</param>
  * </parameters>
  * */
    public void setX(int x);

    /*
    * <summary>
    *     Gets the y coordinate of the current object.
    * </summary>
    * <returns>
    * 	Returns an Integer indicating the y coordinate of the current object.
    * </returns>
    * */
    public int getY();


    /*
  * <summary>
  *     This method is used to set parameter y coordinate of the current object.
  * </summary>
  * <parameters>
  * 	<param type='int'>y</param>
  * </parameters>
  * */
    public void setY(int y);

}
