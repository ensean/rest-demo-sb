package com.rest.example.mapper;

import com.rest.example.dto.UserDTO;
import com.rest.example.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDataMapper {

    UserDataMapper INSTANCE = Mappers.getMapper(UserDataMapper.class);

    UserDTO mapToUserDto(User user);

    List<UserDTO> mapToUserDTOList(List<User> users);

    User mapToUser(UserDTO userDTO);

    List<User> mapToUserList(List<UserDTO> userDTO);
}
