package com.eeehit.board.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;

public interface UserService extends UserDetailsService {
    Collection<? extends GrantedAuthority> getAuthorities(String username);
    PasswordEncoder passwordEncoder();
    List<User> getUserList();
}
