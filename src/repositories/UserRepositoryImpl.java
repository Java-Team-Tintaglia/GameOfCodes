package repositories;

import interfaces.UserRepository;
import interfaces.Writeable;
import models.UserImpl;
import states.*;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import constants.Common;
import constants.Messages;
import interfaces.AuthenticationProvider;
import interfaces.Readable;
import interfaces.State;
import interfaces.User;

public class UserRepositoryImpl implements UserRepository {

    private Map<String, User> users = new HashMap<>();
    private AuthenticationProvider authenticationProvider;
    private Readable reader;
    private Writeable writer;
    
    public UserRepositoryImpl(AuthenticationProvider authenticationProvider, Readable reader, Writeable writer) {
		this.authenticationProvider = authenticationProvider;
		this.reader = reader;
		this.writer = writer;
	}

	public void addUser(User user) {
        if (users.containsKey(user.getUsername())) {
        	State errorMessageState = new ErrorMessageState(
                    String.format(Messages.ALREADY_EXISTING_USER, user.getUsername()),
                    new RegistrationFormState());

            StateManager.setCurrentState(errorMessageState);
        } else if (user.getFirstName().length() == 0
                || user.getLastName().length() == 0
                || user.getPassword().length() == 0
                || user.getUsername().length() == 0) {
        	State errorMessageState = new ErrorMessageState(
            		Messages.FILL_ALL_EMPTY_FIELDS,
                    new RegistrationFormState());

            StateManager.setCurrentState(errorMessageState);
        } else {
            this.users.put(user.getUsername(), user);
            this.save(user);
            State successMessageState = new SuccessMessageState(
            		Messages.SUCCESSFUL_REGISTER,
                    new MainMenuState(this.authenticationProvider));

            StateManager.setCurrentState(successMessageState);
        }
    }

    public void updateUser(User user) {
        String editedData = String.format("%s %s %s %s",
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword());

        this.users.put(user.getUsername(), user);

        FileOutputStream writer = null;
        try {
        StringBuilder text = new StringBuilder();
            String line;
            while ((line = this.reader.readLine()) != null) {
                String[] lineTokens = line.split("\\s+");
                if (lineTokens[0].equals(user.getUsername())) {
                    text.append(editedData);
                } else {
                    text.append(line);
                }
                text.append("\n");
            }

            this.reader.close();
            writer = new FileOutputStream(Common.USERS_FILE_PATH);
            writer.write(text.toString().getBytes());
            
        } catch (FileNotFoundException e) {
            System.out.println(Messages.FILE_FOUNDING_UNSUCCESSFUL);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(Messages.FILE_WRITING_FAILURE);
            e.printStackTrace();
        } finally {
        	try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }

        State successMessageState = new SuccessMessageState(
        		Messages.PROFILE_SUCCESSFUL_EDITING,
                new MainMenuState(this.authenticationProvider));

        StateManager.setCurrentState(successMessageState);
    }

    public User findUserByUsername(String username) {
        User user = null;

        if (!users.containsKey(username)) {
        	State errorMessageState = new ErrorMessageState(
                    String.format(Messages.USER_DOES_NOT_EXIST, username),
                    new LoginFormState());

            StateManager.setCurrentState(errorMessageState);
        } else {
            user = users.get(username);
        }

        return user;
    }

    // load all users from .txt file
    public void load() {
    	try {
    	String line = this.reader.readLine();

            while (line != null) {
                String[] token = line.split(" ");
                String username = token[0];
                String firstName = token[1];
                String lastName = token[2];
                String password = token[3];

                if (!users.containsKey(username)) {
                    User user = new UserImpl(username, firstName, lastName, password);
                    users.put(username, user);
                }

                line = this.reader.readLine();
            }
            this.reader.close();
        } catch (IOException exception) {
            System.err.println(Messages.FILE_READING_FAILURE);
            exception.printStackTrace();
        }
    }

    // Save registered user into a .txt file
    private void save(User user) {
    	try {
    	String output = user.getUsername() + " "
                + user.getFirstName() + " "
                + user.getLastName() + " "
                + user.getPassword();
                
    	this.writer.write(Common.USERS_FILE_PATH, output);

        } catch (IOException exception) {
            System.err.println(Messages.FILE_WRITING_FAILURE);
            exception.printStackTrace();
        }
    }

}
