package eventhandler;

import authentication.AuthenticationProvider;
import authentication.Encoder;
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

public class MouseInput implements MouseListener {
    private Display display;
    private UserRepository userRepository;
    private AuthenticationProvider authenticationProvider;

    public MouseInput(Display display, UserRepository userRepository, AuthenticationProvider authenticationProvider) {
        display.getCanvas().addMouseListener(this);
        this.display = display;
        this.userRepository = userRepository;
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        int mouseX = e.getX();
        int mouseY = e.getY();

        if (StateManager.getCurrentState() instanceof MainMenuState) {

            // Login Button
            if (AuthenticationProvider.currentUser == null && MainMenuState.buttonLogIn.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new LoginFormState());
            }

            // LogOut Button
            if (AuthenticationProvider.currentUser != null && MainMenuState.buttonLogOut.getColliderBox().contains(mouseX, mouseY)) {
                authenticationProvider.logout();
                return;
            }

            // Register Button
            if (AuthenticationProvider.currentUser == null && MainMenuState.buttonRegister.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new RegistrationFormState());
            }

            // Play Button
            if (AuthenticationProvider.currentUser != null && MainMenuState.buttonStart.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new PlayerCustomizationState());
            }

            // Scores Button
            if (AuthenticationProvider.currentUser != null && MainMenuState.buttonScore.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new ScoresState());
            }

            // Profile Button
            if (AuthenticationProvider.currentUser != null && MainMenuState.buttonProfile.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new StudentProfileState());
            }

            // Exit Button
            if (MainMenuState.buttonExit.getColliderBox().contains(mouseX, mouseY)) {
                System.exit(0);
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

            if (PlayerCustomizationState.playButton.getColliderBox().contains(mouseX, mouseY)) {
                StudentType studentType = PlayerCustomizationState.studentType;
                StateManager.setCurrentState(new GameState(studentType));
                PlayerCustomizationState.isSelected = false;

            }
        } else if (StateManager.getCurrentState() instanceof ScoresState) {
            if (ScoresState.backToMenuButton.getColliderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new MainMenuState());
            }
        } else if (StateManager.getCurrentState() instanceof StudentScoreState) {
            if (StudentScoreState.backToMenuButton.getColliderBox().contains(mouseX, mouseY)) {
                StudentScoreState studentScoreState = (StudentScoreState) StateManager.getCurrentState();
                String studentName = studentScoreState.getStudent().getUsername();
                Map<String, List<Integer>> studentGrades = studentScoreState.getStudent().getStudentGrades();
                StudentScoresRepository.saveToFile(studentName, studentGrades);

                StateManager.setCurrentState(new MainMenuState());
            }
        } else if (StateManager.getCurrentState() instanceof RegistrationFormState) {
            if (RegistrationFormState.userRect.contains(mouseX, mouseY)) {
                RegistrationFormState.fieldType = "user";
            } else if (RegistrationFormState.firstRect.contains(mouseX, mouseY)) {
                RegistrationFormState.fieldType = "first";
            } else if (RegistrationFormState.lastRect.contains(mouseX, mouseY)) {
                RegistrationFormState.fieldType = "last";
            } else if (RegistrationFormState.passRect.contains(mouseX, mouseY)) {
                RegistrationFormState.fieldType = "pass";
            } else if (RegistrationFormState.backToMenuButton.getColliderBox().contains(mouseX, mouseY)) {
                RegistrationFormState.fieldType = "user";
                RegistrationFormState.username.setLength(0);
                RegistrationFormState.firstName.setLength(0);
                RegistrationFormState.lastName.setLength(0);
                RegistrationFormState.password.setLength(0);
                StateManager.setCurrentState(new MainMenuState());
            } else if (RegistrationFormState.registerButton.getColliderBox().contains(mouseX, mouseY)) {
                String passwordHash = Encoder.cryptingPassword(RegistrationFormState.password.toString());
                String username = RegistrationFormState.username.toString();
                String firstName = RegistrationFormState.firstName.toString();
                String lastName = RegistrationFormState.lastName.toString();

                User userToRegister = new User(username, firstName, lastName, passwordHash);
                userRepository.addUser(userToRegister);

                RegistrationFormState.fieldType = "user";
                RegistrationFormState.username.setLength(0);
                RegistrationFormState.firstName.setLength(0);
                RegistrationFormState.lastName.setLength(0);
                RegistrationFormState.password.setLength(0);
            }
        } else if (StateManager.getCurrentState() instanceof LoginFormState) {
            if (LoginFormState.userRect.contains(mouseX, mouseY)) {
            	LoginFormState.fieldType = "user";
            } else if (LoginFormState.passRect.contains(mouseX, mouseY)) {
            	LoginFormState.fieldType = "pass";
            } else if (LoginFormState.backToMenuButton.getColliderBox().contains(mouseX, mouseY)) {
            	LoginFormState.fieldType = "user";
            	LoginFormState.username.setLength(0);
            	LoginFormState.password.setLength(0);
                StateManager.setCurrentState(new MainMenuState());
            } else if (LoginFormState.loginButton.getColliderBox().contains(mouseX, mouseY)) {
                String password = LoginFormState.password.toString();
                String username = LoginFormState.username.toString();
                
                authenticationProvider.authenticate(username, password);

                LoginFormState.fieldType = "user";
                LoginFormState.username.setLength(0);
                LoginFormState.password.setLength(0);
            }
        } else if (StateManager.getCurrentState() instanceof ErrorMessageState) {
        	ErrorMessageState ems = (ErrorMessageState) StateManager.getCurrentState();
            if (ErrorMessageState.okButton.getColliderBox().contains(mouseX, mouseY)) {
            	StateManager.setCurrentState(ems.getNextState());
            }
        } else if (StateManager.getCurrentState() instanceof SuccessMessageState) {
        	SuccessMessageState sms = (SuccessMessageState) StateManager.getCurrentState();
            if (SuccessMessageState.okButton.getColliderBox().contains(mouseX, mouseY)) {
            	StateManager.setCurrentState(sms.getNextState());
            }
        }else if(StateManager.getCurrentState() instanceof StudentProfileState) {

            if (StudentProfileState.backToMenuButton.getColliderBox().contains(mouseX, mouseY)){
                StateManager.setCurrentState(new MainMenuState());
            }else if(StudentProfileState.editButton.getColliderBox().contains(mouseX, mouseY)){
                StateManager.setCurrentState(new EditProfileState());
            }

        }else if (StateManager.getCurrentState() instanceof EditProfileState) {
            if (EditProfileState.firstRect.contains(mouseX, mouseY)) {
                EditProfileState.fieldType = "first";
            } else if (EditProfileState.lastRect.contains(mouseX, mouseY)) {
                EditProfileState.fieldType = "last";
            } else if (EditProfileState.passRect.contains(mouseX, mouseY)) {
                EditProfileState.fieldType = "pass";
            } else if(EditProfileState.editButton.getColliderBox().contains(mouseX, mouseY)){
                User user = AuthenticationProvider.currentUser;
                user.setFirstName(EditProfileState.firstName.toString());
                user.setLastName(EditProfileState.lastName.toString());
                String passwordHash = Encoder.cryptingPassword(EditProfileState.password.toString());
                user.setPassword(passwordHash);
                userRepository.updateUser(user);
            } else if (EditProfileState.backToMenuButton.getColliderBox().contains(mouseX, mouseY)) {
                 StateManager.setCurrentState(new MainMenuState());
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
