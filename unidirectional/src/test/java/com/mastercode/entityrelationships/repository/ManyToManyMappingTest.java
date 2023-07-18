package com.mastercode.entityrelationships.repository;

import com.mastercode.entityrelationships.entity.Order;
import com.mastercode.entityrelationships.entity.Role;
import com.mastercode.entityrelationships.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class ManyToManyMappingTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveUser() {
        User user = User.builder()
                .firstName("John")
                .lastName("Kris")
                .email("email@kris.com")
                .password("secret")
                .build();

        Role roleAdmin = Role.builder()
                .name("ROLE_ADMIN")
                .build();

        Role roleCustomer = Role.builder()
                .name("ROLE_CUSTOMER")
                .build();

        user.setRoles(Set.of(roleAdmin, roleCustomer));

        userRepository.save(user);
    }


}
