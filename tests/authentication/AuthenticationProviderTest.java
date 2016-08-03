package authentication;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import graphics.Assets;
import interfaces.AuthenticationProvider;
import interfaces.User;
import interfaces.UserRepository;
import models.UserImpl;

public class AuthenticationProviderTest {

	private static final String USERNAME = "Username";
	private static final String FIRST_NAME = "First";
	private static final String LAST_NAME = "Last";
	private static final String PASSWORD = "1234";
	
	private AuthenticationProvider authenticationProvider;
	private User testUser;
	
	@Mock 
	private UserRepository userRepository;
	
	@Before
	public void setUp() {
		Assets.init();
		MockitoAnnotations.initMocks(this);
		this.authenticationProvider = new AuthenticationProviderImpl(this.userRepository);
		this.testUser = new UserImpl(USERNAME, FIRST_NAME, LAST_NAME, Encoder.cryptingPassword(PASSWORD));
	}
	
	
	@Test
	public void testGetLoggedUserShouldBeNull() {
		User user = this.authenticationProvider.getLoggedUser();
		Assert.assertEquals(null, user);
	}
	
	@Test
	public void testGetLoggedUserShouldNotBeNull() {
		Mockito.when(this.userRepository.findUserByUsername(Mockito.anyString()))
				.thenReturn(this.testUser);
		this.authenticationProvider.authenticate(USERNAME, PASSWORD);
		User actualUser = this.authenticationProvider.getLoggedUser();
		Assert.assertEquals(this.testUser, actualUser);
	}
}
