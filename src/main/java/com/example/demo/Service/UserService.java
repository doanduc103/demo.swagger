package com.example.demo.Service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.User;
import org.springframework.stereotype.Service;

import javax.naming.NameNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public interface UserService {

    List<User> GetListUser();

    User createUser(UserDTO userDTO) throws Exception;

    User EditUser(UserDTO updateReq, int id) throws ClassNotFoundException;

    void deleteUser(int id) throws NameNotFoundException;
}
