package com.example.CRUDSpringBoot;

import com.example.CRUDSpringBoot.service2.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration

public class SecurityConfig  extends WebSecurityConfiguration {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return  bCryptPasswordEncoder;
    }

    @Autowired
    private UserService userDetailsService;
    @Autowired BCryptPasswordEncoder bcrypt;

        @Override
        protected void configure (AuthenticationManagerBuilder auth)
        throws Exception{

        auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
    }
        @Override
        protected void configure (HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }
}
