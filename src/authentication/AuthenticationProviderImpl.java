package authentication;

import constants.Messages;
import interfaces.AuthenticationProvider;
import interfaces.User;
import interfaces.UserRepository;

import states.ErrorMessageState;
import states.LoginFormState;
import states.MainMenuState;
import states.StateManager;
import states.SuccessMessageState;

public class AuthenticationProviderImpl implements AuthenticationProvider {

    private User loggedUser;
    
    private UserRepository userRepository;

    public AuthenticationProviderImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
    
    @Override
    public User getLoggedUser() {
		return loggedUser;
	}


	private void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}

	@Override
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
       
    	this.setLoggedUser(user);
    	
    	SuccessMessageState successMessageState = new SuccessMessageState(
    			Messages.SUCCESSFUL_LOG_IN,
    			new MainMenuState(this));

    	StateManager.setCurrentState(successMessageState);
    }
    
	@Override
    public void logout() {
    	if (this.loggedUser != null) {
    		this.loggedUser = null;
			SuccessMessageState successMessageState = new SuccessMessageState(
					Messages.SUCCESSFUL_LOG_OUT,
					new MainMenuState(this));			

			StateManager.setCurrentState(successMessageState);
			
		} else {
			ErrorMessageState errorMessageState = new ErrorMessageState(
					Messages.NO_LOGGED_IN_USER,
					new MainMenuState(this));
			
			StateManager.setCurrentState(errorMessageState);
		}
    }
}
