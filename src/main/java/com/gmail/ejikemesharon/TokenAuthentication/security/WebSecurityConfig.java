package com.gmail.ejikemesharon.TokenAuthentication.security;


import com.gmail.ejikemesharon.TokenAuthentication.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    public WebSecurityConfig(BCryptPasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

         httpSecurity.cors().and().csrf().disable().authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
                .anyRequest().authenticated())
                //.addFilter(new JWTAuthenticationFilter(authenticationManagerBean()))
                //.addFilter(new JWTAuthorizationFilter(authenticationManagerBean()))
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        httpSecurity.authenticationProvider(authenticationProvider());

        return httpSecurity.build();

//        httpSecurity.cors().and().csrf().disable().authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .addFilter(new JWTAuthenticationFilter(authenticationManagerBean()))
//                .addFilter(new JWTAuthorizationFilter(authenticationManagerBean()))
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);



        //return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean(/*HttpSecurity httpSecurity*/) throws Exception {
        //AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
       // authenticationManagerBuilder.inMemoryAuthentication().withUser("user").password("password").roles("ADMIN");
        return new ProviderManager(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(passwordEncoder);

        return provider;
    }
}
