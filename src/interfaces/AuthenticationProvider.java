package interfaces;

public interface AuthenticationProvider {
	void authenticate(String username, String password);
	void logout();
	User getLoggedUser();
}
