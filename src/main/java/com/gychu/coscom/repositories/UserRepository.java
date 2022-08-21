package com.gychu.coscom.repositories;

import com.gychu.coscom.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { //Using JPARepo interface since it extends CrudRepo interface.

    User findByUsername(String username);
}
