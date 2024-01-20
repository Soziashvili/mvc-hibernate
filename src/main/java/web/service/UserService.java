package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> listUsers();

    User findUserById(int id);

    void deleteUser(int id);

    void updateUser(int id, User user);
}
