package com.gmail.ejikemesharon.TokenAuthentication;

import com.gmail.ejikemesharon.TokenAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest createUserRequest) {
        User user = new User();
        user.setName(createUserRequest.getName());

        if (!Objects.equals(createUserRequest.getPassword(), createUserRequest.getConfirmPassword())) {
            return ResponseEntity.badRequest().build();
        }

        user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));

        userRepository.save(user);

        String userName = user.getName();

        return new ResponseEntity<>(userName, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<String> testAuth() {
        String message = "Successfully tested authentication API";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
