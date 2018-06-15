package ro.utm.java.service;

import ro.utm.java.entities.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
