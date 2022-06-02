package ru.denisqaa.dao;

import ru.denisqaa.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsersByCount(int number);

    List<User> getUsers();

    User getById(int id);

    void saveUser(User user);

    void updateUser(User user, int id);

    void delete(int id);
}
