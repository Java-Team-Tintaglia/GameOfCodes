package repositories;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import authentication.Encoder;
import graphics.Assets;
import interfaces.AuthenticationProvider;
import interfaces.User;
import interfaces.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest {

	private static final String USERNAME = "Username";
	private static final String PASSWORD_HASH = Encoder.cryptingPassword("1234");
	private static final String FIRST_NAME = "First";
	private static final String LAST_NAME = "Last";
	
	//TODO: bufferedReader as dependencyInjection
	@Mock
	private BufferedReader bufferedReader;
	
	private UserRepository userRepository;
	
	@Mock
	private AuthenticationProvider authenticationProvider;
	
	@Before
	public void setUp() {
		Assets.init();
		this.userRepository = new UserRepositoryImpl(this.authenticationProvider, null, null);
		String line = String.format("%s %s %s %s%n", USERNAME, FIRST_NAME, LAST_NAME, PASSWORD_HASH);
		try {
			Mockito.when(this.bufferedReader.readLine()).thenReturn(line);
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
		System.out.println(this.bufferedReader.readLine().toString());
		
		User actualUser = this.userRepository.findUserByUsername(notExistingUser);
		Assert.assertNull(actualUser);
	}
}
