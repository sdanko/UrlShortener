package com.urlshortener.core;


import com.urlshortener.user.User;
import com.urlshortener.user.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner{
    private  final UserRepository users;

    public DatabaseLoader(UserRepository users) {
        this.users = users;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
//        users.save(new User("test", "test"));
    }
}
