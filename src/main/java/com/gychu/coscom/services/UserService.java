package com.gychu.coscom.services;

import com.gychu.coscom.models.User;
import com.gychu.coscom.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    //dependency injection for UserRepository
    @Autowired
    UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

}
