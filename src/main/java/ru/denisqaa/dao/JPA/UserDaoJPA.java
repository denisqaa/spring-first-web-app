package ru.denisqaa.dao.JPA;

import org.springframework.stereotype.Repository;
import ru.denisqaa.dao.UserDao;
import ru.denisqaa.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoJPA implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    private final String getUsersHql = String.format("From %s", User.class.getSimpleName());

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery(getUsersHql).getResultList();
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getUsersByCount(int count) {
        List<User> users = entityManager.createQuery(getUsersHql).setMaxResults(count).getResultList();
        return users;
    }

    @Override
    public void updateUser(User user, int id) {
        User existUser = entityManager.find(User.class, id);
        if (existUser == null) {
            return;
        }

        existUser.setId(user.getId());
        existUser.setName(user.getName());
        existUser.setPassword(user.getPassword());

        entityManager.merge(existUser);
    }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
