package authentication;

import models.User;

/**
 * Created by PetyoPetrov on 25.06.2016 г..
 */
public class AuthenticationProvider {

    static User loggedUser;

    public User authenticate(User user){
        loggedUser=new User(
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword()
                );
        //metod koito proverqva v bazata danni za takuv user at all
//        boolean isExisting;
//        if(isExisting){
//
//        }else {
//
//        }
//        if(loggedUser.getPassword().equals(Encoder.getCryptedPassword())){
//
//        }else {
//
//        }
        //aako do tuk ne hvurli Exception vru6tame koito lognatiq user

        return loggedUser;

    }
}
