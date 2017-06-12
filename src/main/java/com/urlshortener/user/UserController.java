package com.urlshortener.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @RequestMapping(method = RequestMethod.POST)
//    ResponseEntity<?> add(@RequestBody String accountId) {
//
//
//    }
}
