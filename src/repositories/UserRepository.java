package repositories;

import models.User;
import states.ErrorMessageState;
import states.LoginFormState;
import states.MainMenuState;
import states.RegistrationFormState;
import states.StateManager;
import states.SuccessMessageState;
import utils.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserRepository {

    private Map<String, User> users = new HashMap<>();

    public void addUser(User user) {
        if (users.containsKey(user.getUsername())) {
            ErrorMessageState errorMessageState = new ErrorMessageState(
                    "User " + user.getUsername() + " already exist!",
                    new RegistrationFormState());

            StateManager.setCurrentState(errorMessageState);
        } else {
            users.put(user.getUsername(), user);
            save(user);
            SuccessMessageState successMessageState = new SuccessMessageState(
                    "You have successfully registered!",
                    new MainMenuState());

            StateManager.setCurrentState(successMessageState);
        }
    }


   
    public void updateUser(User user) {
        this.users.put(user.getUsername(), user);

        // TODO: find the user with that username from .txt and replace the row with the new data
        
    }

    public User findUserByUsername(String username) {
        User user = null;

        if (!users.containsKey(username)) {
            ErrorMessageState errorMessageState = new ErrorMessageState(
                    "User with " + username + " does NOT exists!",
                    new LoginFormState());

            StateManager.setCurrentState(errorMessageState);
        } else {
            user = users.get(username);
        }

        return user;
    }

    public Iterable<User> getAllUsers() {
        List<User> allUsers = users.values().stream().collect(Collectors.toList());
        return allUsers;
    }

    // load all users from .txt file
    public void load() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Constants.USERS_FILE_PATH))) {
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] token = line.split(" ");
                String username = token[0];
                String firstName = token[1];
                String lastName = token[2];
                String password = token[3];

                if (!users.containsKey(username)) {
                    User user = new User(username, firstName, lastName, password);
                    users.put(username, user);
                }

                line = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            System.err.println("Cannot read file.");
            exception.printStackTrace();
        }
    }

    // Save registered user into a .txt file
    private void save(User user) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(Constants.USERS_FILE_PATH, true), true)) {
            writer.println(user.getUsername() + " "
                    + user.getFirstName() + " "
                    + user.getLastName() + " "
                    + user.getPassword());

        } catch (IOException exception) {
            System.err.println("Cannot write to file");
            exception.printStackTrace();
        }
    }

}
