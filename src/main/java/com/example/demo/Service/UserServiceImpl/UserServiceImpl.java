package com.example.demo.Service.UserServiceImpl;

import com.example.demo.DTO.Mapper;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.naming.NameNotFoundException;
import java.util.List;
import java.util.Optional;


@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<User> GetListUser() {
        return userRepository.findAll();

    }

    @Override
    public User createUser(UserDTO userDTO) throws Exception {
        User user = userRepository.findByEmail(userDTO.getEmail());
        if (user != null) {
            throw new Exception("Email đã tồn tại");
        }
        user = mapper.toUser(userDTO);
        userRepository.save(user);
        return user;
    }

    @Override
    public User EditUser(UserDTO updateReq, int id) throws ClassNotFoundException {

        Optional<User> userId = userRepository.findById(id);
        User user = userId.get();
        if (userId == null) {
            throw new ClassNotFoundException("ko tim thay tai khoan");
        } else if (user.getEmail().equals(updateReq.getEmail())) {
            throw new DuplicateKeyException("Email đã có người sử dụng");
        }
        user = mapper.toUser(updateReq);
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(int id) throws NameNotFoundException {
        Optional<User> userId = userRepository.findById(id);
        User user = userId.get();

        if (userId == null) {
            throw new NameNotFoundException("Ko tim thay tai khoan");
        }
        userRepository.delete(user);
    }
}




