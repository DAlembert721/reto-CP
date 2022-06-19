package com.ddmu.retocp.domain.repository;

import com.ddmu.retocp.domain.model.ERole;
import com.ddmu.retocp.domain.model.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends BaseRepository<Role, String>{
    Optional<Role> findByName(ERole name);
}
