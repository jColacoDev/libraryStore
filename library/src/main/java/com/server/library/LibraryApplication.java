package com.server.library;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.server.library.config.SecurityUtility;
import com.server.library.domain.security.User;
import com.server.library.domain.security.UserRole;
import com.server.library.repository.RoleRepository;
import com.server.library.service.UserService;
import com.server.library.domain.security.Role;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;

	@Autowired
    private RoleRepository roleRepository;
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        // Create roles
        Role role1 = new Role();
        role1.setName("ROLE_MASTER");
        role1.setRoleId(1);
        roleRepository.save(role1);

        // Create users with associated roles
        for (int i = 1; i <= 3; i++) {
            User user = new User();
            user.setFirstName(getRandomName());
            user.setLastName(getRandomName());
            user.setUsername("user" + i);
            user.setPassword(SecurityUtility.passwordEncoder().encode("password"));
            user.setEmail("user" + i + "@example.com");
            
            Set<UserRole> userRoles = new HashSet<>();
            UserRole userRole1 = new UserRole(user, role1);
            userRoles.add(userRole1);
            userService.createUser(user, userRoles);
        }
    }

    private String getRandomName() {
        String[] names = {"John", "Alice", "Michael", "Emma", "Daniel", "Olivia", "David", "Sophia", "James", "Isabella"};
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }
}
