package com.server.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.server.library.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
    
}
