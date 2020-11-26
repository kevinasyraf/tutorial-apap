package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.UserModel;
import apap.tutorial.haidokter.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDb userDB;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDB.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public UserModel getByUsername(String username) {
        return userDB.findByUsername(username);
    }

    @Override
    public boolean passwordMatch(String password1, String password2) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean oldAndNewPasswordMatch = passwordEncoder.matches(password1, password2);
        return oldAndNewPasswordMatch;
    }

//    @Override
//    public void updatePassword(UserModel user, String oldPassword, String newPassword) {
//        UserModel updatedUser = userDB.findByUsername(user.getUsername());
//        if (passwordMatch(user.getPassword(), newPassword)) {
//            user.setPassword(newPassword);
//        }
//
//    }
}
