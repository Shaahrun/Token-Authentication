package com.gmail.ejikemesharon.TokenAuthentication;

import com.gmail.ejikemesharon.TokenAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

   // List<User> userList = new ArrayList<>();

   /* public void addData() {
        User user1 = new User(1L, "Shannon", "12345");
        User user2 = new User(2L, "Kelvin", "16782");
        User user3 = new User(3L, "Candace", "78962");


        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }*/

    public boolean findUser(User user) {
        User userPresent = userRepository.findByName(user.getName());

        //boolean userPresent = userList.contains(user.getName());

        return userPresent != null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), Collections.emptyList());
    }
}
