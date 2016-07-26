package authentication;

import models.User;
import repositories.UserRepository;
import states.ErrorMessageState;
import states.LoginFormState;
import states.MainMenuState;
import states.StateManager;
import states.SuccessMessageState;
import utils.Constants;
import utils.Messages;

public class AuthenticationProvider {

    public static User currentUser;
    
    private UserRepository userRepository;

    public AuthenticationProvider(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
    
    public void authenticate(String username, String password) {
    	User user = this.userRepository.findUserByUsername(username);

    	if (user == null) {

    		ErrorMessageState errorMessageState = new ErrorMessageState(
    				String.format(Messages.USER_WAS_NOT_FOUND, username),
    				new LoginFormState());
    		
    		StateManager.setCurrentState(errorMessageState);
    		return;
		} 
    	
    	String decodedPass = Encoder.decryptPassword(user.getPassword());
    	if (!password.equals(decodedPass)) {
    		ErrorMessageState errorMessageState = new ErrorMessageState(
    				Messages.PASSWORD_DOES_NOT_MATCH,
    				new LoginFormState());
    		
    		StateManager.setCurrentState(errorMessageState);
    		return;
		} 
       
    	currentUser = user;
    	
    	SuccessMessageState successMessageState = new SuccessMessageState(
    			Messages.SUCCESSFUL_LOG_IN,
    			new MainMenuState());

    	StateManager.setCurrentState(successMessageState);
    }
    
    public void logout() {
    	if (currentUser != null) {
    		currentUser = null;
			SuccessMessageState successMessageState = new SuccessMessageState(
					Messages.SUCCESSFUL_LOG_OUT,
					new MainMenuState());			

			StateManager.setCurrentState(successMessageState);
			
		} else {
			ErrorMessageState errorMessageState = new ErrorMessageState(
					Messages.NO_LOGGED_IN_USER,
					new MainMenuState());
			
			StateManager.setCurrentState(errorMessageState);
		}
    }
}
