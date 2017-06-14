package com.urlshortener.user;

import com.urlshortener.core.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class UserController extends BaseController{
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<RegistrationResult> add(@RequestBody RegistrationRequest registration) {
        User user = userRepository.findByAccountId(registration.getAccountId());

        if(user != null)
            return ResponseEntity.status(HttpStatus.CONFLICT).
                    body(new RegistrationResult(false, "Account with that id already exists", ""));
        try {
            String password = randomAlphaNumeric(8);

            userRepository.save(new User(registration.getAccountId(), password));

            return ResponseEntity.status(HttpStatus.OK).
                    body(new RegistrationResult(true, "Your account is opened", password));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(new RegistrationResult(false, "There was an error while creating the account", ""));
        }
    }

}
