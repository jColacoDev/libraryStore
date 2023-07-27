package com.server.library.domain.security;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Role implements Serializable{
    
    private static final long serialVersionUID = 890245234L;

    @Id
    private int roleId;

    private String name;

    @OneToMany(mappedBy="role", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<>();

    public Role(){}

    public int getRoleId() {
        return this.roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRole> getUserRoles() {
        return this.userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
