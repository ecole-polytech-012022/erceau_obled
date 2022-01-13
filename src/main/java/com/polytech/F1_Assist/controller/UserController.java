package com.polytech.F1_Assist.controller;

import com.polytech.F1_Assist.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.stereotype.Controller;
        import org.springframework.http.ResponseEntity;

        import java.util.*;

@RequestMapping("/users")
@Controller
public class UserController {

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {

        User user1 = new User();
        user1.setName("user1");
        user1.setEmail("mail@test.com");
        user1.setAge(34);

        User user2 = new User();
        user2.setName("user2");
        user2.setEmail("mail2@test.com");
        user2.setAge(21);

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        return ResponseEntity.ok(list);
    }

}