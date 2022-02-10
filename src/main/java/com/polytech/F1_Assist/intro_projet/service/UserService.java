package com.polytech.F1_Assist.intro_projet.service;

import com.polytech.F1_Assist.intro_projet.model.User;
import com.polytech.F1_Assist.intro_projet.repository.UserRepository;
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
        User mechanic1 = new User();
        mechanic1.setName("mechanic1");
        mechanic1.setTimeScrewTyre(0.93);
        mechanic1.setTimeRemoveTyre(0.65);
        mechanic1.setTimeAddTyre(0.71);
        mechanic1.setAvailable(false);

        User mechanic2 = new User();
        mechanic2.setName("mechanic2");
        mechanic2.setTimeScrewTyre(0.91);
        mechanic2.setTimeRemoveTyre(0.67);
        mechanic2.setTimeAddTyre(0.70);
        mechanic2.setAvailable(true);

        User mechanic3 = new User();
        mechanic3.setName("mechanic3");
        mechanic3.setTimeScrewTyre(0.96);
        mechanic3.setTimeRemoveTyre(0.74);
        mechanic3.setTimeAddTyre(0.73);
        mechanic3.setAvailable(true);

        User mechanic4 = new User();
        mechanic4.setName("mechanic4");
        mechanic4.setTimeScrewTyre(0.91);
        mechanic4.setTimeRemoveTyre(0.63);
        mechanic4.setTimeAddTyre(0.78);
        mechanic4.setAvailable(true);

        User mechanic5 = new User();
        mechanic5.setName("mechanic5");
        mechanic5.setTimeScrewTyre(0.88);
        mechanic5.setTimeRemoveTyre(0.61);
        mechanic5.setTimeAddTyre(0.58);
        mechanic5.setAvailable(true);

        User mechanic6 = new User();
        mechanic6.setName("mechanic6");
        mechanic6.setTimeScrewTyre(0.98);
        mechanic6.setTimeRemoveTyre(0.69);
        mechanic6.setTimeAddTyre(0.82);
        mechanic6.setAvailable(true);

        User mechanic7 = new User();
        mechanic7.setName("mechanic7");
        mechanic7.setTimeScrewTyre(0.72);
        mechanic7.setTimeRemoveTyre(0.64);
        mechanic7.setTimeAddTyre(0.76);
        mechanic7.setAvailable(false);

        User mechanic8 = new User();
        mechanic8.setName("mechanic8");
        mechanic8.setTimeScrewTyre(0.99);
        mechanic8.setTimeRemoveTyre(0.39);
        mechanic8.setTimeAddTyre(0.63);
        mechanic8.setAvailable(true);

        User mechanic9 = new User();
        mechanic9.setName("mechanic9");
        mechanic9.setTimeScrewTyre(0.78);
        mechanic9.setTimeRemoveTyre(0.58);
        mechanic9.setTimeAddTyre(0.75);
        mechanic9.setAvailable(true);

        User mechanic10 = new User();
        mechanic10.setName("mechanic10");
        mechanic10.setTimeScrewTyre(0.84);
        mechanic10.setTimeRemoveTyre(0.67);
        mechanic10.setTimeAddTyre(0.81);
        mechanic10.setAvailable(true);

        User mechanic11 = new User();
        mechanic11.setName("mechanic11");
        mechanic11.setTimeScrewTyre(0.90);
        mechanic11.setTimeRemoveTyre(0.66);
        mechanic11.setTimeAddTyre(0.79);
        mechanic11.setAvailable(true);

        User mechanic12 = new User();
        mechanic12.setName("mechanic12");
        mechanic12.setTimeScrewTyre(0.91);
        mechanic12.setTimeRemoveTyre(0.63);
        mechanic12.setTimeAddTyre(0.78);
        mechanic12.setAvailable(true);

        User mechanic13 = new User();
        mechanic13.setName("mechanic13");
        mechanic13.setTimeScrewTyre(1.01);
        mechanic13.setTimeRemoveTyre(0.53);
        mechanic13.setTimeAddTyre(0.48);
        mechanic13.setAvailable(true);

        User mechanic14 = new User();
        mechanic14.setName("mechanic14");
        mechanic14.setTimeScrewTyre(0.71);
        mechanic14.setTimeRemoveTyre(0.64);
        mechanic14.setTimeAddTyre(0.62);
        mechanic14.setAvailable(true);

        User mechanic15 = new User();
        mechanic15.setName("mechanic15");
        mechanic15.setTimeScrewTyre(0.56);
        mechanic15.setTimeRemoveTyre(0.45);
        mechanic15.setTimeAddTyre(0.39);
        mechanic15.setAvailable(true);

        this.repository.save(mechanic1);
        this.repository.save(mechanic2);
        this.repository.save(mechanic3);
        this.repository.save(mechanic4);
        this.repository.save(mechanic5);
        this.repository.save(mechanic6);
        this.repository.save(mechanic7);
        this.repository.save(mechanic8);
        this.repository.save(mechanic9);
        this.repository.save(mechanic10);
        this.repository.save(mechanic11);
        this.repository.save(mechanic12);
        this.repository.save(mechanic13);
        this.repository.save(mechanic14);
        this.repository.save(mechanic15);
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
        if (givenUser.getName() != null) {
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