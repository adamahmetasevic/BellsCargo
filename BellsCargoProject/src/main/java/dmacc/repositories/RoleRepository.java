package dmacc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}