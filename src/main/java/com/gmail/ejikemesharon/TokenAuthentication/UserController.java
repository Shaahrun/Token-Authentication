package com.gmail.ejikemesharon.TokenAuthentication;

import com.gmail.ejikemesharon.TokenAuthentication.repository.UserRepository;
import com.gmail.ejikemesharon.TokenAuthentication.security.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    TokenUtil tokenUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody AuthenticateUserRequest authenticateUserRequest) {
        User user = new User();
        user.setName(authenticateUserRequest.getName());
        user.setPassword(authenticateUserRequest.getPassword());

        if (userService.findUser(user)) {
            String token = tokenUtil.generateToken(user);
            AuthenticationResponse response = new AuthenticationResponse(user.getName(), token);
            return new ResponseEntity<>(response, HttpStatus.OK);

        } else return  ResponseEntity.notFound().build();
    }
}
