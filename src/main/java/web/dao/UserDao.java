package web.dao;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;


public interface UserDao {

    void addUser(User user);

    List<User> listUsers();

    User findUserById(int id);
}
