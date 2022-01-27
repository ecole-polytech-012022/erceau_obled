package com.polytech.F1_Assist.service;

import com.polytech.F1_Assist.model.User;
import com.polytech.F1_Assist.repository.UserRepository;
import org.springframework.stereotype.Service;
//import com.polytech.auth.model.User;

import java.util.*;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
        this.initUsers();
    }
    public List<User> list = new ArrayList<>();
    public Integer id = 1;

    public void initUsers() {
        User user1 = new User();
        user1.setName("user1");
        user1.setEmail("mail@test.com");
        user1.setAge(21);
        user1.setPassword("passwd1");

        User user2 = new User();
        user2.setName("user2");
        user2.setEmail("mail2@test.com");
        user2.setAge(132);
        user2.setPassword("passwd2");

        User user3 = new User();
        user3.setName("user3");
        user3.setEmail("mail3@test.com");
        user3.setAge(133);
        user3.setPassword("passwd3");

        this.repository.save(user1);
        this.repository.save(user2);
        this.repository.save(user3);
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

    public User getUserById(Integer id) {
        Optional<User> found = this.repository.findById(id);
        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }

    /*public User getUserByAge(Integer age) {
        Optional<User> found = this.repository.findById(age);
        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }*/

    public User createUser(User givenUser) {
        if (givenUser.getName() != null && givenUser.getEmail() != null && givenUser.getAge() != null && givenUser.getPassword() != null) {
            return this.repository.save(givenUser);
        }
        return null;
    }

    public boolean deleteUserById(Integer userId) {
        User found = getUserById(userId);
        if (found != null) {
            this.repository.deleteById(found.getId());
            return true;
        }
        return false;
    }
}