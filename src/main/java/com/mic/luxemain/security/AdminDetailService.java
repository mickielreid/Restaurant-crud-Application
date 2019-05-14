package com.mic.luxemain.security;

import com.mic.luxemain.Repository.AdminRepository;
import com.mic.luxemain.domain.Admin;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class AdminDetailService implements UserDetailsService {

    AdminRepository adminRepository;

    public AdminDetailService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(userName);

        if(admin != null){
            return admin;
        }else {
            throw new UsernameNotFoundException(userName + "Could Not be found");
        }


    }
}
