package states;

import interfaces.Drawable;
import interfaces.Updatable;
import repositories.UserRepository;

public abstract class State implements Drawable, Updatable{
	 
	private UserRepository userRepository;
	   
    public State(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	} 
}
