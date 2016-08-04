package interfaces;

/**
 * This interface defines the behavior for the Engine of the game.
 */
public interface GameEngine extends Runnable{
	
	/**
	 *  This method starts the game engine
	 */
	void start();
	
	/**
	 *  This method stops the game engine
	 */
	void stop();
}
