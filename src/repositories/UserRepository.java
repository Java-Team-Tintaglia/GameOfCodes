package repositories;

import interfaces.User;

import java.util.ArrayList;

public class UserRepository {
    static int counter = 1;

    private ArrayList<User> users = new ArrayList<>();



    public void addUser(User user){

        if (users.contains(user)) {
            System.out.println("User already exist");
            return;
        }

        users.add(user);
        counter++;
    }
    public void getFullName(String userName){



    }
    public static void updateUser(Integer id,User user){




    }
    public User findUserByUsername(String searchedName){
        for (User user : users) {
            if (user.getUsername().equals(searchedName)) {
                return user;
            }
        }
        return null;
    }
}
