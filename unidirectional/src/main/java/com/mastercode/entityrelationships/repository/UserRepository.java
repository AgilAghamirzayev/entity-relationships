package com.mastercode.entityrelationships.repository;

import com.mastercode.entityrelationships.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
