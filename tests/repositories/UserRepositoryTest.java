package repositories;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.mockito.runners.MockitoJUnitRunner;

import authentication.Encoder;
import graphics.Assets;
import interfaces.AuthenticationProvider;
import interfaces.Readable;
import interfaces.State;
import interfaces.User;
import interfaces.UserRepository;
import interfaces.Writeable;
import models.UserImpl;
import states.ErrorMessageState;
import states.StateManager;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest {

	private static final String USERNAME = "Username";
	private static final String PASSWORD_HASH = Encoder.cryptingPassword("1234");
	private static final String FIRST_NAME = "First";
	private static final String LAST_NAME = "Last";
	
	@Mock
	private Readable mockedReader;
	
	@Mock
	private Writeable mockedWriter;
	
	private UserRepository userRepository;
	
	@Mock
	private AuthenticationProvider authenticationProvider;
	
	@Before
	public void setUp() {
		Assets.init();
		this.userRepository = new UserRepositoryImpl(this.authenticationProvider, mockedReader, mockedWriter);
		String line = String.format("%s %s %s %s%n", USERNAME, FIRST_NAME, LAST_NAME, PASSWORD_HASH);
		try {
			Mockito.when(this.mockedReader.readLine()).thenReturn(line).thenReturn(null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.userRepository.load();
	}
	
	@Test
	public void testFindUserByUsernameShouldPass() {
		User actualUser = this.userRepository.findUserByUsername(USERNAME);
		Assert.assertEquals(USERNAME, actualUser.getUsername());
	}
	
	@Test
	public void testFindUserByUsernameShouldBeNull() throws IOException {
		String notExistingUser = "NotExist";		
		User actualUser = this.userRepository.findUserByUsername(notExistingUser);
		Assert.assertNull(actualUser);
	}
	
	@Test
	public void testAlreadyRegisteredUserErrorMessage() {
		User user = new UserImpl(USERNAME, FIRST_NAME, LAST_NAME, PASSWORD_HASH);
		this.userRepository.addUser(user);
		State actualState = StateManager.getCurrentState();
		Assert.assertTrue(actualState instanceof ErrorMessageState);
	}
	
}
