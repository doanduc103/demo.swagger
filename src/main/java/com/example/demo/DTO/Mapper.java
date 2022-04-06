package com.example.demo.DTO;

import com.example.demo.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    User user = new User();
    UserDTO userDTO = new UserDTO();

    //convert DTO - entity
    public User toUser(UserDTO userDTO) {
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setAvatar(userDTO.getAvatar());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        return user;
    }

    public UserDTO toUserDTO(User user, UserDTO userDTO) {
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setAvatar(user.getAvatar());
        return userDTO;
    }
}
