package web.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import web.models.User;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = em.createQuery("from User").getResultList();
        return users;
    }
    //    EntityManager#remove() works only on entities which are managed
    //    in the current transaction/context.
    //    retrieving the entity in an earlier transaction,
    //    storing it in the HTTP session and then attempting to remove it in
    //    a different transaction/context.
    //    This em.remove(user) -  won't work.
    @Override
    public void deleteUser(User user) {
        em.flush();
        em.remove(em.contains(user) ? user : em.merge(user));
    }

    @Override
    public User getUser(long userid) {
        return em.find(User.class, userid);
    }

    @Override
    public void updateUser(int id, User updateUser) {
        em.merge(updateUser);

    }
}
