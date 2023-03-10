package com.gmail.ejikemesharon.TokenAuthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = {"com.gmail.ejikemesharon.TokenAuthentication"}, exclude = {SecurityAutoConfiguration.class})
public class TokenAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TokenAuthenticationApplication.class, args);
	}

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
