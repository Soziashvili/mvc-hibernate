package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class UserDaoImp implements UserDao {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public UserDaoImp(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Transactional
    @Override
    public void add(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Transactional
    @Override
    public List<User> listUsers() {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.createQuery("from User", User.class).getResultList();
    }

    @Transactional
    @Override
    public User findUserById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        User user = em.find(User.class, id);
        em.detach(user);
        return user;
    }
}
