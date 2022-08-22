package com.gychu.coscom.repositories;

import com.gychu.coscom.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> { //Using JPARepo interface since it extends CrudRepo interface.

    Optional<UserProfile> findByUsername(String username);
}
