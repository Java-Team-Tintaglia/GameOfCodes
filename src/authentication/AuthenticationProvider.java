package authentication;

import models.User;
import repositories.UserRepository;
import states.ErrorMessageState;
import states.LogInFormState;
import states.MainMenuState;
import states.StateManager;
import states.SuccessMessageState;

public class AuthenticationProvider {

    public static User currentUser;
    private UserRepository userRepository;
    

    public AuthenticationProvider(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
    
    public void authenticate(String username, String password) {
    	User user = userRepository.findUserByUsername(username);

    	if (user == null) {
    		ErrorMessageState errorMessageState = new ErrorMessageState(
    				"User with username: " + username + " was NOT found!",
    				new LogInFormState());
    		
    		StateManager.setCurrentState(errorMessageState);
    		return;
		} 
    	
    	String decodedPass = Encoder.decryptPassword(user.getPassword());
    	if (!password.equals(decodedPass)) {
    		ErrorMessageState errorMessageState = new ErrorMessageState(
    				"Password does NOT match!",
    				new LogInFormState());
    		
    		StateManager.setCurrentState(errorMessageState);
    		return;
		} 
       
    	currentUser = user;
    	
    	SuccessMessageState successMessageState = new SuccessMessageState(
    			"You have logged in sucessfully!",
    			new MainMenuState());
    	
    	StateManager.setCurrentState(successMessageState);
    }
    
    public void logout() {
    	if (currentUser != null) {
    		currentUser = null;
			SuccessMessageState successMessageState = new SuccessMessageState(
					"You have logged out successfully!",
					new MainMenuState());			

			StateManager.setCurrentState(successMessageState);
			
		} else {
			ErrorMessageState errorMessageState = new ErrorMessageState(
					"There is no logged in user!",
					new MainMenuState());
			
			StateManager.setCurrentState(errorMessageState);
		}
    }
}
