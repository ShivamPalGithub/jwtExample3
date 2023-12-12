package com.jwt.example.service;

import com.jwt.example.dao.UserRepository;
import com.jwt.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
@Autowired
    private UserRepository userRepository;
//    private List<User> store = new ArrayList<>();

   /* public UserService() {
        store.add(new User(UUID.randomUUID().toString(), "shivam", "shivam@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(), "akash", "akash@gmail.com"));

    }*/

   /* public List<User> getStore() {
        return this.store;
    }*/




    public List<User> getUser() {
        return this.userRepository.findAll();
    }

    public User createUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return this.userRepository.save(user);
    }
    public List<User> get() {
        return this.userRepository.findAll();
    }

}
