package com.gmail.ejikemesharon.TokenAuthentication.repository;

import com.gmail.ejikemesharon.TokenAuthentication.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);

    User findByNameAndPassword(String name, String password);
}
