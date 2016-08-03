package interfaces;
/*
* <summary>
* 	This interface defines the behaviour for the object that will exist.
* </summary>
* */

public interface Existable {
		/*
	* <summary>
	*     This method is used to check if the object exists.
	* </summary>
	* <returns>
	*     A boolean indicating whether the objects exists or not.
	* </returns>
	* */

	boolean isExist();
/*
	* <summary>
	*     This method is used to set the existing state of an Existable object.
	* </summary>
	* <parameters>
	* 	<param type='boolean'>exist</param>
	* </parameters>
	* */

	void setExist(boolean exist);
}