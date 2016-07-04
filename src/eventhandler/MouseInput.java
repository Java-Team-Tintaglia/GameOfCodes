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
                StateManager.setCurrentState(new LogInFormState());
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

            // Select player
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
        } else if (StateManager.getCurrentState() instanceof LogInFormState) {
            if (LogInFormState.userRect.contains(mouseX, mouseY)) {
                LogInFormState.fieldType = "user";
            } else if (LogInFormState.passRect.contains(mouseX, mouseY)) {
                LogInFormState.fieldType = "pass";
            } else if (LogInFormState.backToMenuButton.getColliderBox().contains(mouseX, mouseY)) {
                LogInFormState.fieldType = "user";
                LogInFormState.username.setLength(0);
                LogInFormState.password.setLength(0);
                StateManager.setCurrentState(new MainMenuState());
            } else if (LogInFormState.loginButton.getColliderBox().contains(mouseX, mouseY)) {
                String password = LogInFormState.password.toString();
                String username = LogInFormState.username.toString();
                
                authenticationProvider.authenticate(username, password);

                LogInFormState.fieldType = "user";
                LogInFormState.username.setLength(0);
                LogInFormState.password.setLength(0);
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
        } else if (StateManager.getCurrentState() instanceof StudentProfileState) {
            if (StudentProfileState.firstRect.contains(mouseX, mouseY)) {
                StudentProfileState.fieldType = "first";
            } else if (StudentProfileState.lastRect.contains(mouseX, mouseY)) {
                StudentProfileState.fieldType = "last";
            } else if (StudentProfileState.passRect.contains(mouseX, mouseY)) {
                StudentProfileState.fieldType = "pass";
            } else if(StudentProfileState.editButton.getColliderBox().contains(mouseX, mouseY)){
                User user = AuthenticationProvider.currentUser;
                user.setFirstName(StudentProfileState.firstName.toString());
                user.setLastName(StudentProfileState.lastName.toString());
                String passwordHash = Encoder.cryptingPassword(StudentProfileState.password.toString());
                user.setPassword(passwordHash);
                
                userRepository.updateUser(user);

            } else if (StudentProfileState.backToMenuButton.getColliderBox().contains(mouseX, mouseY)) {
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
