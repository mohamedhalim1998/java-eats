package com.mohamed.halim.javaeats.jwt;

import com.mohamed.halim.javaeats.repository.AdminRepository;
import com.mohamed.halim.javaeats.repository.CustomerRepository;
import com.mohamed.halim.javaeats.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AdminRepository adminRepository;
    private final ManagerRepository managerRepository;
    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var admin = adminRepository.findByEmailOrName(username, username);
        if(admin.isPresent()) {
            return admin.get();
        }
        var manager = managerRepository.findByEmailOrName(username, username);
        if(manager.isPresent()) {
            return manager.get();
        }
        var customer = customerRepository.findByEmailOrName(username, username);
        if(customer.isPresent()) {
            return customer.get();
        }
        throw new UsernameNotFoundException(username);
    }
}
