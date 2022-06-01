package ru.denisqaa.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.denisqaa.dto.UserDTO;
import ru.denisqaa.model.User;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);

    User toUser(UserDTO dto);

    List<UserDTO> toDTO(List<User> userList);
}
