package ru.denisqaa.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.denisqaa.dao.UserDao;
import ru.denisqaa.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements ru.denisqaa.service.UserService {
    private final UserDao userDao;

    @Override
    public List<User> getUsersByCount(int count) {
        return userDao.getUsersByCount(count);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(User user, int id) {
        userDao.updateUser(user, id);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
