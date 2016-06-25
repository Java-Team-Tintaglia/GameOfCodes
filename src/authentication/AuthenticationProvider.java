package authentication;

import models.User;
import repositories.UserRepository;

public class AuthenticationProvider {

    public static User currentUser;
    private UserRepository userRepository;

    public AuthenticationProvider(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
    
    public void authenticate(String username, String password) {
    	User user = userRepository.findUserByUsername(username);

    	if (user == null) {
			// TODO new ErrorState
    		return;
		} 
    	
    	String decodedPass = Encoder.decryptPassword(user.getPassword());
    	System.out.println(decodedPass);
    	if (!password.equals(decodedPass)) {
    		// TODO new ErrorState
    		return;
		} 
       
    	currentUser = user;

    }
    
    public void logout() {
    	if (currentUser != null) {
			currentUser = null;
			// new SuccessState
		} else {
			// new ErrorState
		}
    }
}
