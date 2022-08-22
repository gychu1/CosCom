package com.gychu.coscom.services;

import com.gychu.coscom.models.UserProfile;
import com.gychu.coscom.repositories.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserProfileService {

    //dependency injection for UserRepository
    @Autowired
    UserProfileRepository userProfileRepository;

    public UserProfile saveUser(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public UserProfile getUserByUsername(String username) {
        Optional<UserProfile> maybeUserProfile = userProfileRepository.findByUsername(username);
        if (maybeUserProfile.isPresent()) {
            return maybeUserProfile.get();
        } else {
            throw new IllegalArgumentException(String.format("No user found for username %s", username));
        }
    }

    public List<UserProfile> getAllUsers () {
        return userProfileRepository.findAll();
    }

    public UserProfile updateUser (String username, UserProfile userProfile) {
        UserProfile oldUserProfile = getUserByUsername(username);

        oldUserProfile.setUsername(userProfile.getUsername());
        oldUserProfile.setEmail(userProfile.getEmail());
        oldUserProfile.setAge(userProfile.getAge());
        oldUserProfile.setName(userProfile.getName());
        oldUserProfile.setProfileImage(userProfile.getProfileImage());

        userProfileRepository.save(oldUserProfile);

        return oldUserProfile;
    }

    public Boolean deleteUser(String username) {
        UserProfile userProfileToDelete = getUserByUsername(username);
        userProfileRepository.delete(userProfileToDelete);
        return Boolean.TRUE;
    }


}
