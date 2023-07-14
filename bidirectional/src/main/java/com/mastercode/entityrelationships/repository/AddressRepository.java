package com.mastercode.entityrelationships.repository;

import com.mastercode.entityrelationships.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
