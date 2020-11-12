package com.derteuffel.scpt.repositories;

import com.derteuffel.scpt.entities.Role;
import com.derteuffel.scpt.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByName(ERole name);
}
