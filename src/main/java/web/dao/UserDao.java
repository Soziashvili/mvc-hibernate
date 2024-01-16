package web.dao;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

@Service
public interface UserDao {

    void add(User user);

    List<User> listUsers();

    User findUserById(int id);
}
