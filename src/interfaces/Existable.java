package interfaces;

/**
 * This interface defines the behavior for the object that will exist.
 */
public interface Existable {
	
	/**
	 * This method is used to check if the object exists.
	 * @return  A boolean indicating whether the objects exists or not.
	 */
	boolean isExist();

	/**
	 *  This method is used to set the existing state of an existing object.
	 * @param exist - the object that will exist.
	 */
	void setExist(boolean exist);
}