package com.polytech.F1_Assist.controller;

import com.polytech.F1_Assist.dto.UserDTO;
import com.polytech.F1_Assist.mapper.UserMapper;
import com.polytech.F1_Assist.model.User;
import com.polytech.F1_Assist.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.*;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        List<User> users = userService.getAllUsers();
        List<UserDTO> usersDtos = UserMapper.toUserDTOList(users);

        return ResponseEntity.ok(usersDtos);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId) {

        User user = userService.getUserById(userId);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        UserDTO dto = UserMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto) {
        User fromDto = UserMapper.toUser(dto);
        User createdUser = userService.createUser(fromDto);
        if (createdUser == null) {
            return ResponseEntity.badRequest().build();
        }
        UserDTO createdUserDto = UserMapper.toUserDTO(createdUser);
        return ResponseEntity.ok(createdUserDto);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<List<User>> deleteUserById(@PathVariable Integer userId) {
        boolean userDeleted = userService.deleteUserById(userId);
        if (userDeleted == false) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
