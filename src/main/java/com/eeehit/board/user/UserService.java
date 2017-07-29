package com.eeehit.board.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;

public interface UserService extends UserDetailsService {
    Collection<? extends GrantedAuthority> getAuthorities(String username);
}
