package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements  UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public List<User> listUsers() {
        return null;
    }

    @Transactional
    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }
}
