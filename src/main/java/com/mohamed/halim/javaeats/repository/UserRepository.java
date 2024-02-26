package com.mohamed.halim.javaeats.repository;

import com.mohamed.halim.javaeats.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByName(String name);
    Optional<AppUser> findByEmail(String name);


}
