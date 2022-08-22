package com.gychu.coscom.repositories;

import com.gychu.coscom.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> { //Using JPARepo interface since it extends CrudRepo interface.

    UserProfile findByUsername(String username);
}
