package com.ddmu.retocp.service;

import com.ddmu.retocp.domain.model.ERole;
import com.ddmu.retocp.domain.model.Role;
import com.ddmu.retocp.domain.model.User;
import com.ddmu.retocp.domain.repository.RoleRepository;
import com.ddmu.retocp.domain.repository.UserRepository;
import com.ddmu.retocp.domain.service.UserService;
import com.ddmu.retocp.exception.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;


    @Override
    public User createUser(User user) {
        if(userRepository.existsUserByEmail(user.getEmail())) {
            throw new UserAlreadyExistException("User already exists!");
        }
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        user.setRoles(roles);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }
}
