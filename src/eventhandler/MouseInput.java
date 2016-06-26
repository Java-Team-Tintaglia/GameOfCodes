package eventhandler;

import enums.StudentType;
import graphics.Display;
import models.User;
import repositories.StudentScoresRepository;
import repositories.UserRepository;
import states.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Map;

import authentication.AuthenticationProvider;
import authentication.Encoder;

public class MouseInput implements MouseListener {
	private Display display;
	private UserRepository userRepository;

    public MouseInput(Display display, UserRepository userRepository) {
        display.getCanvas().addMouseListener(this);
        this.display = display;    
        this.userRepository = userRepository;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        int mouseX = e.getX();
        int mouseY = e.getY();

        if(StateManager.getCurrentState() instanceof MainMenuState) {
        	// Login Button 
        	if(AuthenticationProvider.currentUser == null && MainMenuState.buttonLogin.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new LogInFormState(userRepository));

            }
        	
        	// Register Button
        	if(AuthenticationProvider.currentUser == null && MainMenuState.buttonRegister.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new RegistrationFormState(userRepository));
            }
        	
            // Play Button
        	if(AuthenticationProvider.currentUser != null && MainMenuState.buttonStart.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new PlayerCustomizationState(userRepository));
            }

            // Scores Button
            if (AuthenticationProvider.currentUser != null && MainMenuState.buttonScore.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new ScoresState(userRepository));
            }
            
            // Exit Button
            if (MainMenuState.buttonExit.getColliderBox().contains(mouseX, mouseY)) {
                System.exit(0);
            	// TESTING LOGIN/LOGOUT
//                AuthenticationProvider ap = new AuthenticationProvider(userRepository);
//                ap.authenticate("MARIA", "MIMI");
//                System.out.println(AuthenticationProvider.currentUser);
//                ap.logout();
                // end of testing
            }
            
        } else if (StateManager.getCurrentState() instanceof PlayerCustomizationState) {
            
        	// Select player
            if (PlayerCustomizationState.badBoyButton.getColliderBox().contains(mouseX, mouseY)) {
                PlayerCustomizationState.studentType = StudentType.BAD_BOY;
                PlayerCustomizationState.isSelected = true;
            } else if (PlayerCustomizationState.hotChickButton.getColliderBox().contains(mouseX, mouseY)) {
                PlayerCustomizationState.studentType = StudentType.HOT_CHICK;
                PlayerCustomizationState.isSelected = true;
            } else if (PlayerCustomizationState.nerdBoyButton.getColliderBox().contains(mouseX, mouseY)) {
                PlayerCustomizationState.studentType = StudentType.NERD_BOY;
                PlayerCustomizationState.isSelected = true;
            } else if (PlayerCustomizationState.nerdLadyButton.getColliderBox().contains(mouseX, mouseY)) {
                PlayerCustomizationState.studentType = StudentType.NERD_LADY;
                PlayerCustomizationState.isSelected = true;
            }
        	
        	// Eenter a name 
        	if (PlayerCustomizationState.playButton.getColliderBox().contains(mouseX, mouseY)) {
        		String name = PlayerCustomizationState.stringBuilger.toString();
        		StudentType type = PlayerCustomizationState.studentType;
        		
                StateManager.setCurrentState(new GameState(userRepository, type, name));
                
                PlayerCustomizationState.stringBuilger.setLength(0);
                PlayerCustomizationState.isSelected = false;
                
            }
        } else if (StateManager.getCurrentState() instanceof ScoresState) {
        	if (ScoresState.backToMenuButton.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new MainMenuState(userRepository));
            }
        } else if (StateManager.getCurrentState() instanceof StudentScoreState) {
        	if (StudentScoreState.backToMenuButton.getColliderBox().contains(mouseX, mouseY)) {
        		StudentScoreState studentScoreState = (StudentScoreState)StateManager.getCurrentState();
        		String studentName = studentScoreState.getStudent().getUsername();
        		Map<String, List<Integer>> studentGrades = studentScoreState.getStudent().getStudentGrades();
        		
        		StudentScoresRepository.saveToFile(studentName, studentGrades);
        		
                StateManager.setCurrentState(new MainMenuState(userRepository));
            }
        } else if (StateManager.getCurrentState() instanceof RegistrationFormState) {
            if (RegistrationFormState.userRect.contains(mouseX, mouseY)) {
                RegistrationFormState.isFieldSelected = true;
                RegistrationFormState.fieldType = "user";
            } else if (RegistrationFormState.firstRect.contains(mouseX, mouseY)) {
                RegistrationFormState.isFieldSelected = true;
                RegistrationFormState.fieldType = "first";
            } else if (RegistrationFormState.lastRect.contains(mouseX, mouseY)) {
                RegistrationFormState.isFieldSelected = true;
                RegistrationFormState.fieldType = "last";
            } else if (RegistrationFormState.passRect.contains(mouseX, mouseY)) {
                RegistrationFormState.isFieldSelected = true;
                RegistrationFormState.fieldType = "pass";
            } else if (RegistrationFormState.backToMenuButton.getColliderBox().contains(mouseX, mouseY)) {
                RegistrationFormState.isFieldSelected = false;
                RegistrationFormState.fieldType = null;
                RegistrationFormState.username.setLength(0);
                RegistrationFormState.firstName.setLength(0);
                RegistrationFormState.lastName.setLength(0);
                RegistrationFormState.password.setLength(0);
                StateManager.setCurrentState(new MainMenuState(userRepository));
            } else if (RegistrationFormState.registerButton.getColliderBox().contains(mouseX, mouseY)) {
            	String passwordHash = Encoder.cryptingPassword(RegistrationFormState.password.toString());
            	String username = RegistrationFormState.username.toString();
            	String firstName = RegistrationFormState.firstName.toString();
            	String lastName = RegistrationFormState.lastName.toString();
            	
            	User userToRegister = new User(username, firstName, lastName, passwordHash);
            	userRepository.addUser(userToRegister);
            	
            	RegistrationFormState.isFieldSelected = false;
                RegistrationFormState.fieldType = null;
                RegistrationFormState.username.setLength(0);
                RegistrationFormState.firstName.setLength(0);
                RegistrationFormState.lastName.setLength(0);
                RegistrationFormState.password.setLength(0);
                
                StateManager.setCurrentState(new MainMenuState(userRepository));
            }
        }else if (StateManager.getCurrentState() instanceof LogInFormState) {
            if (LogInFormState.userRect.contains(mouseX, mouseY)) {
                LogInFormState.isFieldSelected = true;
                LogInFormState.fieldType = "user";
            } else if (LogInFormState.passRect.contains(mouseX, mouseY)) {
                LogInFormState.isFieldSelected = true;
                LogInFormState.fieldType = "pass";
            } else if (LogInFormState.backToMenuButton.getColliderBox().contains(mouseX, mouseY)) {
                LogInFormState.isFieldSelected = false;
                LogInFormState.fieldType = null;
                LogInFormState.username.setLength(0);
                LogInFormState.password.setLength(0);
                StateManager.setCurrentState(new MainMenuState(userRepository));
            } else if (LogInFormState.loginButton.getColliderBox().contains(mouseX, mouseY)) {
                String passwordHash = Encoder.cryptingPassword(LogInFormState.password.toString());
                String username = LogInFormState.username.toString();

                User userToRegister = new User(username, passwordHash);
                userRepository.addUser(userToRegister);

                LogInFormState.isFieldSelected = false;
                LogInFormState.fieldType = null;
                LogInFormState.username.setLength(0);
                LogInFormState.password.setLength(0);

//                StateManager.setCurrentState(new MainMenuState(userRepository));
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
