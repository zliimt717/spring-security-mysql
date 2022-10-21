package com.example.security.service;

import com.example.security.entity.AppUser;
import com.example.security.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG="username with  %s not found";

    private final AppUserRepository appUserRepository;
    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        AppUser appUser=appUserRepository.findByusername(name);

        if(appUser==null){
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,name));
        }

        UserDetails user= User.withUsername(appUser.getUsername())
                .password(appUser.getPassword())
                .authorities(appUser.getAuthorities())
                .build();
        return user;
    }

}
