package com.example.demo.Controller;

import com.example.demo.DTO.Mapper;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    Mapper mapper;


    @ApiOperation(value = "Get List User", response = User.class, httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500,message = "ERROR"),
            @ApiResponse(code = 404,message = "ERROR"),
            @ApiResponse(code = 403,message = "ERROR")
    })
    @GetMapping("/users")
    public ResponseEntity<?> GetListUser() {
        userService.GetListUser();
        return ResponseEntity.status(HttpStatus.OK).body("Ok");
    }

    @ApiOperation(value = "Create User ", response = UserDTO.class,httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500,message = "ERROR"),
            @ApiResponse(code = 404,message = "ERROR"),
            @ApiResponse(code = 403,message = "ERROR")
    })
    @PostMapping("/user/create")
    public ResponseEntity<?> createUser(@RequestBody User user, UserDTO userDTO) throws Exception {
        userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }

    @GetMapping("/")
    public String index() {
        return "123";
    }

    @ApiOperation(value = "Update User",code = 200,httpMethod = "PUT", response = User.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500,message = "ERROR"),
            @ApiResponse(code = 404,message = "ERROR"),
            @ApiResponse(code = 403,message = "ERROR")
    })
    @PutMapping("/user/{id}")
    public ResponseEntity<?> EditUser(@PathVariable("id") int id, @RequestBody UserDTO updatereq) throws Exception {

        userService.EditUser(updatereq, id);
        return ResponseEntity.status(200).body("Edit user thành công");
    }

    @ApiOperation(value = "Delete user", code = 200 , httpMethod = "DELETE", response = User.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500,message = "ERROR"),
            @ApiResponse(code = 404,message = "ERROR"),
            @ApiResponse(code = 403,message = "ERROR")
    })
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> DeleteUser(@PathVariable("id") int id) {
        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("Delete user thành công");
    }
}