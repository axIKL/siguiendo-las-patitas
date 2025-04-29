package com.siguiendolaspatitas.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    
    @Autowired
    private UserRepository uR;

    public User register(User NewUser, BindingResult result) {
        
        String passsword = NewUser.getPassword();
        String confirm = NewUser.getConfirm();

        if(!passsword.equals(confirm)){
            result.rejectValue("confirm", "Matches", "The password must match the confirm password.");
        }

        String email = NewUser.getEmail();
        User userExist = uR.findByEmail(email);

        if(userExist != null){
            result.rejectValue("email", "Matches", "The email already exists.");
        }

        if(result.hasErrors()){
            return null;
        }else {
        String passHash = BCrypt.hashpw(passsword, BCrypt.gensalt());
        NewUser.setPassword(passHash);
        return uR.save(NewUser);
        }

    }
    public User login(String email, String password) {
        User userTryingLogin = uR.findByEmail(email);

        if (User  userTryingLogin == null){
            return null;
    }

    if(BCrypt.checkpw(password, userTryingLogin.getPassword())){
        return userTryingLogin;
    }else {
        return null;
    }
    }
}