package com.eeehit.board.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public User loadUserByUsername(String id) {
        User user = this.userRepository.findByUsername(id);
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(String id) {
        User user = this.userRepository.findByUsername(id);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getAuthority()));
        return authorities;
    }
}
