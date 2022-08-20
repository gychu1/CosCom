package com.gychu.coscom.services;

import com.gychu.coscom.models.User;
import com.gychu.coscom.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    //dependency injection for UserRepository
    @Autowired
    UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers () {
        return userRepository.findAll();
    }

    public User updateUser (String username, User user) {
        User oldUser = getUserByUsername(username);

        oldUser.setUsername(user.getUsername());
        oldUser.setEmail(user.getEmail());
        oldUser.setAge(user.getAge());
        oldUser.setName(user.getName());
        oldUser.setProfileImage(user.getProfileImage());

        userRepository.save(oldUser);

        return oldUser;
    }

    public Boolean deleteUser(String username) {
        User userToDelete = getUserByUsername(username);
        userRepository.delete(userToDelete);
        return Boolean.TRUE;
    }


}
