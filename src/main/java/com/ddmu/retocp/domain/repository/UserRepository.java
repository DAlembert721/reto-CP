package com.ddmu.retocp.domain.repository;

import com.ddmu.retocp.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, String>{
    Optional<User> findByEmail(String email);
    Boolean existsUserByEmail(String email);
}
