package com.mohamed.halim.javaeats.repository;

import com.mohamed.halim.javaeats.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface UserRepository<T extends AppUser> extends JpaRepository<T, Long> {
    Optional<T> findByName(String name);
    Optional<T> findByEmail(String name);
    Optional<T> findByEmailOrName(String name, String email);


}
