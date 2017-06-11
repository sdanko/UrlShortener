package com.urlshortener.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DetailsService implements UserDetailsService{
    @Autowired
    UserRepository users;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = users.findByAccountId(s);
        if(user == null) {
            throw new UsernameNotFoundException(s + "was not found");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getAccountId(),
                user.getPassword(),
                AuthorityUtils.createAuthorityList()
        );
    }
}
