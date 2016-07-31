package repositories;

import models.UserImpl;
import states.*;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import constants.Common;
import constants.Messages;

public class UserRepository {

    private Map<String, UserImpl> userImpls = new HashMap<>();

    public void addUser(UserImpl userImpl) {
        if (userImpls.containsKey(userImpl.getUsername())) {
            ErrorMessageState errorMessageState = new ErrorMessageState(
                    String.format(Messages.ALREADY_EXISTING_USER, userImpl.getUsername()),
                    new RegistrationFormState());

            StateManager.setCurrentState(errorMessageState);
        } else if (userImpl.getFirstName().length() == 0
                || userImpl.getLastName().length() == 0
                || userImpl.getPassword().length() == 0
                || userImpl.getUsername().length() == 0) {
            ErrorMessageState errorMessageState = new ErrorMessageState(
            		Messages.FILL_ALL_EMPTY_FIELDS,
                    new RegistrationFormState());

            StateManager.setCurrentState(errorMessageState);
        } else {
            userImpls.put(userImpl.getUsername(), userImpl);
            save(userImpl);
            SuccessMessageState successMessageState = new SuccessMessageState(
            		Messages.SUCCESSFUL_REGISTER,
                    new MainMenuState());

            StateManager.setCurrentState(successMessageState);
        }
    }


   
    public void updateUser(UserImpl userImpl) {
        String editedData = String.format("%s %s %s %s",
                userImpl.getUsername(),
                userImpl.getFirstName(),
                userImpl.getLastName(),
                userImpl.getPassword());

        this.userImpls.put(userImpl.getUsername(), userImpl);

        FileOutputStream writer = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(Common.USERS_FILE_PATH))) {
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineTokens = line.split("\\s+");
                if (lineTokens[0].equals(userImpl.getUsername())) {
                    text.append(editedData);
                } else {
                    text.append(line);
                }
                text.append("\n");
            }

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

        SuccessMessageState successMessageState = new SuccessMessageState(
        		Messages.PROFILE_SUCCESSFUL_EDITING,
                new MainMenuState());

        StateManager.setCurrentState(successMessageState);
    }

    public UserImpl findUserByUsername(String username) {
        UserImpl userImpl = null;

        if (!userImpls.containsKey(username)) {
            ErrorMessageState errorMessageState = new ErrorMessageState(
                    String.format(Messages.USER_DOES_NOT_EXIST, username),
                    new LoginFormState());

            StateManager.setCurrentState(errorMessageState);
        } else {
            userImpl = userImpls.get(username);
        }

        return userImpl;
    }

    public Iterable<UserImpl> getAllUsers() {
        List<UserImpl> allUsers = userImpls.values().stream().collect(Collectors.toList());
        return allUsers;
    }

    // load all users from .txt file
    public void load() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Common.USERS_FILE_PATH))) {
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] token = line.split(" ");
                String username = token[0];
                String firstName = token[1];
                String lastName = token[2];
                String password = token[3];

                if (!userImpls.containsKey(username)) {
                    UserImpl userImpl = new UserImpl(username, firstName, lastName, password);
                    userImpls.put(username, userImpl);
                }

                line = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            System.err.println(Messages.FILE_READING_FAILURE);
            exception.printStackTrace();
        }
    }

    // Save registered user into a .txt file
    private void save(UserImpl userImpl) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(Common.USERS_FILE_PATH, true), true)) {
            writer.println(userImpl.getUsername() + " "
                    + userImpl.getFirstName() + " "
                    + userImpl.getLastName() + " "
                    + userImpl.getPassword());

        } catch (IOException exception) {
            System.err.println(Messages.FILE_WRITING_FAILURE);
            exception.printStackTrace();
        }
    }

}
