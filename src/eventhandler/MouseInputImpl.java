package eventhandler;

import authentication.Encoder;
import enums.StudentType;
import graphics.Display;
import interfaces.AuthenticationProvider;
import interfaces.StudentScoresRepository;
import interfaces.User;
import interfaces.UserRepository;
import models.UserImpl;
import states.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Map;

public class MouseInputImpl implements MouseListener {
	
    private Display display;
    private UserRepository userRepository;
    private AuthenticationProvider authenticationProvider;
    private StudentScoresRepository studentScoresRepository;

    public MouseInputImpl(Display display, 
    		UserRepository userRepository,
    		AuthenticationProvider authenticationProvider,
    		StudentScoresRepository studentScoresRepository) {
        display.getCanvas().addMouseListener(this);
        this.display = display;
        this.userRepository = userRepository;
        this.authenticationProvider = authenticationProvider;
        this.studentScoresRepository = studentScoresRepository;
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
            if (this.authenticationProvider.getLoggedUser() == null && MainMenuState.buttonLogIn.getCollideBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new LoginFormState());
            }

            // LogOut Button
            if (this.authenticationProvider.getLoggedUser() != null && MainMenuState.buttonLogOut.getCollideBox().contains(mouseX, mouseY)) {
            	this.authenticationProvider.logout();
                return;
            }

            // Register Button
            if (this.authenticationProvider.getLoggedUser() == null && MainMenuState.buttonRegister.getCollideBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new RegistrationFormState());
            }

            // Play Button
            if (this.authenticationProvider.getLoggedUser() != null && MainMenuState.buttonStart.getCollideBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new PlayerCustomizationState(this.authenticationProvider));
            }

            // Scores Button
            if (this.authenticationProvider.getLoggedUser() != null && MainMenuState.buttonScore.getCollideBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new ScoresState(this.studentScoresRepository));
            }

            // Profile Button
            if (this.authenticationProvider.getLoggedUser() != null && MainMenuState.buttonProfile.getCollideBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new StudentProfileState(this.studentScoresRepository, this.authenticationProvider));
                StudentProfileState.firstName = new StringBuilder(this.authenticationProvider.getLoggedUser().getFirstName());
                StudentProfileState.lastName = new StringBuilder(this.authenticationProvider.getLoggedUser().getLastName());
            }

            // Exit Button
            if (MainMenuState.buttonExit.getCollideBox().contains(mouseX, mouseY)) {
                System.exit(0);
            }
        } else if (StateManager.getCurrentState() instanceof PlayerCustomizationState) {

            // Select player
            if (PlayerCustomizationState.badBoyButton.getCollideBox().contains(mouseX, mouseY)) {
                PlayerCustomizationState.studentType = StudentType.BAD_BOY;
                PlayerCustomizationState.isSelected = true;
            } else if (PlayerCustomizationState.hotChickButton.getCollideBox().contains(mouseX, mouseY)) {
                PlayerCustomizationState.studentType = StudentType.HOT_CHICK;
                PlayerCustomizationState.isSelected = true;
            } else if (PlayerCustomizationState.nerdBoyButton.getCollideBox().contains(mouseX, mouseY)) {
                PlayerCustomizationState.studentType = StudentType.NERD_BOY;
                PlayerCustomizationState.isSelected = true;
            } else if (PlayerCustomizationState.nerdLadyButton.getCollideBox().contains(mouseX, mouseY)) {
                PlayerCustomizationState.studentType = StudentType.NERD_LADY;
                PlayerCustomizationState.isSelected = true;
            }

            if (PlayerCustomizationState.playButton.getCollideBox().contains(mouseX, mouseY)) {
                StudentType studentType = PlayerCustomizationState.studentType;
                String username =  this.authenticationProvider.getLoggedUser().getUsername();
                String fullName = this.authenticationProvider.getLoggedUser().getFirstName() + " " 
                					+ this.authenticationProvider.getLoggedUser().getLastName(); 
                StateManager.setCurrentState(new GameState(studentType, username, fullName));
                PlayerCustomizationState.isSelected = false;

            } else if (PlayerCustomizationState.backToMenuButton.getCollideBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new MainMenuState(this.authenticationProvider));
                PlayerCustomizationState.isSelected = false;
                PlayerCustomizationState.studentType = StudentType.BAD_BOY;
            }
        } else if (StateManager.getCurrentState() instanceof ScoresState) {
            if (ScoresState.backToMenuButton.getCollideBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new MainMenuState(this.authenticationProvider));
            }
        } else if (StateManager.getCurrentState() instanceof StudentScoreState) {
            if (StudentScoreState.backToMenuButton.getCollideBox().contains(mouseX, mouseY)) {
                StudentScoreState studentScoreState = (StudentScoreState) StateManager.getCurrentState();
                String studentUsername = studentScoreState.getStudent().getUsername();
                Map<String, List<Integer>> studentGrades = studentScoreState.getStudent().getStudentGrades();
                this.studentScoresRepository.saveToFile(studentUsername, studentGrades);

                StateManager.setCurrentState(new MainMenuState(this.authenticationProvider));
            }
        } else if (StateManager.getCurrentState() instanceof RegistrationFormState) {
            if (RegistrationFormState.usernameRectangle.contains(mouseX, mouseY)) {
                RegistrationFormState.fieldType = "user";
            } else if (RegistrationFormState.firstNameRectangle.contains(mouseX, mouseY)) {
                RegistrationFormState.fieldType = "first";
            } else if (RegistrationFormState.lastNameRectangle.contains(mouseX, mouseY)) {
                RegistrationFormState.fieldType = "last";
            } else if (RegistrationFormState.passwordRectangle.contains(mouseX, mouseY)) {
                RegistrationFormState.fieldType = "pass";
            } else if (RegistrationFormState.backToMenuButton.getCollideBox().contains(mouseX, mouseY)) {
                RegistrationFormState.fieldType = "user";
                RegistrationFormState.username.setLength(0);
                RegistrationFormState.firstName.setLength(0);
                RegistrationFormState.lastName.setLength(0);
                RegistrationFormState.password.setLength(0);
                StateManager.setCurrentState(new MainMenuState(this.authenticationProvider));
            } else if (RegistrationFormState.registerButton.getCollideBox().contains(mouseX, mouseY)) {
                String passwordHash = Encoder.cryptingPassword(RegistrationFormState.password.toString());
                String username = RegistrationFormState.username.toString();
                String firstName = RegistrationFormState.firstName.toString();
                String lastName = RegistrationFormState.lastName.toString();

                User userToRegister = new UserImpl(username, firstName, lastName, passwordHash);
                this.userRepository.addUser(userToRegister);

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
            } else if (LoginFormState.backToMenuButton.getCollideBox().contains(mouseX, mouseY)) {
            	LoginFormState.fieldType = "user";
            	LoginFormState.username.setLength(0);
            	LoginFormState.password.setLength(0);
                StateManager.setCurrentState(new MainMenuState(this.authenticationProvider));
            } else if (LoginFormState.loginButton.getCollideBox().contains(mouseX, mouseY)) {
                String password = LoginFormState.password.toString();
                String username = LoginFormState.username.toString();
                
                this.authenticationProvider.authenticate(username, password);

                LoginFormState.fieldType = "user";
                LoginFormState.username.setLength(0);
                LoginFormState.password.setLength(0);
                
                if (this.authenticationProvider.getLoggedUser() != null) {
                    EditProfileState.firstName = new StringBuilder(this.authenticationProvider.getLoggedUser().getFirstName());
                    EditProfileState.lastName = new StringBuilder(this.authenticationProvider.getLoggedUser().getLastName());
                    EditProfileState.password = new StringBuilder(Encoder.decryptPassword(this.authenticationProvider.getLoggedUser().getPassword()));
                    StudentProfileState.firstName = new StringBuilder(this.authenticationProvider.getLoggedUser().getFirstName());
                    StudentProfileState.lastName = new StringBuilder(this.authenticationProvider.getLoggedUser().getLastName());
                }
            }
        } else if (StateManager.getCurrentState() instanceof ErrorMessageState) {
        	ErrorMessageState errorMessageState = (ErrorMessageState) StateManager.getCurrentState();
            if (ErrorMessageState.okButton.getCollideBox().contains(mouseX, mouseY)) {
            	StateManager.setCurrentState(errorMessageState.getNextState());
            }
        } else if (StateManager.getCurrentState() instanceof SuccessMessageState) {
        	SuccessMessageState successMessageState = (SuccessMessageState) StateManager.getCurrentState();
            if (SuccessMessageState.okButton.getCollideBox().contains(mouseX, mouseY)) {
            	StateManager.setCurrentState(successMessageState.getNextState());
            }
        }else if(StateManager.getCurrentState() instanceof StudentProfileState) {

            if (StudentProfileState.backToMenuButton.getCollideBox().contains(mouseX, mouseY)){
                StateManager.setCurrentState(new MainMenuState(this.authenticationProvider));
            }else if(StudentProfileState.editButton.getCollideBox().contains(mouseX, mouseY)){
                StateManager.setCurrentState(new EditProfileState(this.authenticationProvider));
            }

        }else if (StateManager.getCurrentState() instanceof EditProfileState) {
            if (EditProfileState.firstNameRectangle.contains(mouseX, mouseY)) {
                EditProfileState.fieldType = "first";
            } else if (EditProfileState.lastNameRectangle.contains(mouseX, mouseY)) {
                EditProfileState.fieldType = "last";
            } else if (EditProfileState.passwordRectangle.contains(mouseX, mouseY)) {
                EditProfileState.fieldType = "pass";
            } else if(EditProfileState.editButton.getCollideBox().contains(mouseX, mouseY)){
                User user = this.authenticationProvider.getLoggedUser();
                user.setFirstName(EditProfileState.firstName.toString());
                user.setLastName(EditProfileState.lastName.toString());
                String passwordHash = Encoder.cryptingPassword(EditProfileState.password.toString());
                user.setPassword(passwordHash);
                this.userRepository.updateUser(user);
            } else if (EditProfileState.backToMenuButton.getCollideBox().contains(mouseX, mouseY)) {
                 StateManager.setCurrentState(new MainMenuState(this.authenticationProvider));
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
