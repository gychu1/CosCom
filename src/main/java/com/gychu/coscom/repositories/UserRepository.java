package com.gychu.coscom.repositories;

import com.gychu.coscom.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUserName(String username);
}
