package ro.utm.java.service;

import ro.utm.java.entities.User;

import java.util.List;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
    public List<User> getAllUsers();
    public void removeUser(User user);
    public void updateUser(User user);
}
