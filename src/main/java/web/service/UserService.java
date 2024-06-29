package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getAllUsers();

    void deleteUser(User user);

    User getUser(long userid);

    void updateUser(int id, User user);
}
