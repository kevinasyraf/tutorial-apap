package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);

    public String encrypt(String password);

    public UserModel getByUsername(String username);

    boolean passwordMatch(String oldPassword, String newPassword);

//    void updatePassword(UserModel user, String oldPassword, String newPassword);
}
