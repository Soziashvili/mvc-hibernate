package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    List<User> listUsers();

    User findUserById(int id);
}
