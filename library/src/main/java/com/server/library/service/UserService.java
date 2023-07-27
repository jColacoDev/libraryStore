package com.server.library.service;

import java.util.Set;

import com.server.library.domain.security.User;
import com.server.library.domain.security.UserRole;

public interface UserService {
    
    User createUser(User user, Set<UserRole> userRoles);
}
