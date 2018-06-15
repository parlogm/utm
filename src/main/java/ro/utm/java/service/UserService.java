package ro.utm.java.service;

import ro.utm.java.entities.User;

import java.util.List;

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user);
    List<User> getAllUsers();
    void removeUser(User user);
    void updateUser(User user);
}
