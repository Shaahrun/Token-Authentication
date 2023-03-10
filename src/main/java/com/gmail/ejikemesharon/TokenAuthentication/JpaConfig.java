package com.gmail.ejikemesharon.TokenAuthentication;

import org.hibernate.SessionFactory;
//import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/*@Configuration
@EnableJpaRepositories(basePackages = "com.gmail.ejikemesharon.TokenAuthentication.repository")
public class JpaConfig {

    @Bean(name = "entityManagerFactory")
    public SessionFactory sessionFactoryBean(HibernateEntityManagerFactory entityManagerFactory) {
        //LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        return entityManagerFactory.getSessionFactory();
    }
}*/
