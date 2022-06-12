package org.casjedcem.Farmshop.service;

import org.casjedcem.Farmshop.model.CustomerUserDetail;
import org.casjedcem.Farmshop.model.Enduser;
import org.casjedcem.Farmshop.repository.EnduserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomerEnduserDetailService implements UserDetailsService {

    @Autowired
    EnduserRepository enduserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Enduser> enduser = enduserRepository.findEnduserByEmail(email);
        enduser.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return enduser.map(CustomerUserDetail::new).get();
    }
}
