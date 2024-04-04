package com.mohamed.halim.javaeats.jwt;

import com.mohamed.halim.javaeats.repository.AdminRepository;
import com.mohamed.halim.javaeats.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AdminRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseGet(() -> userRepository.findByName(username).orElseThrow(() -> new UsernameNotFoundException(username)));
    }
}
