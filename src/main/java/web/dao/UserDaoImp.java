package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    public void addUser(User user) {
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

    @Transactional
    @Override
    public void deleteUser(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("delete User where id = :id");
        query.setParameter("id", id);
        em.joinTransaction();
        query.executeUpdate();
        em.flush();
        em.clear();
    }

    @Transactional
    @Override
    public void updateUser(int id, User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("update User set firstName = :firstName, lastName = :lastName, email = :email where id = :id");
        query.setParameter("firstName", user.getFirstName());
        query.setParameter("lastName", user.getLastName());
        query.setParameter("email", user.getEmail());
        query.setParameter("id", id);
        em.joinTransaction();
        query.executeUpdate();
    }
}
