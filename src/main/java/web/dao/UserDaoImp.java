package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.User;

import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class UserDaoImp implements UserDao {

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public UserDaoImp(EntityManagerFactory entityManagerFactory) {
        System.out.println("entity manager");

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
        TypedQuery<User> query = (TypedQuery<User>) em.createQuery("from User");
        return query.getResultList();

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
