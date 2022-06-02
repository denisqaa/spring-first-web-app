package ru.denisqaa.service;

import ru.denisqaa.dto.UserDTO;
import ru.denisqaa.model.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsersByCount(int number);

    List<UserDTO> getUsers();

    UserDTO getById(int id);

    void saveUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO, int id);

    void delete(int id);
}
