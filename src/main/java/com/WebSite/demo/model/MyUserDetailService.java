package com.WebSite.demo.model;

import com.WebSite.demo.dataBase.UserDao;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class MyUserDetailService implements UserDetailsService {
    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(UserDao.findByName(username));
        return user.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
