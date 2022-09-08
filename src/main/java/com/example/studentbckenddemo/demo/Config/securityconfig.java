package com.example.studentbckenddemo.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

@EnableWebSecurity
public class securityconfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("admin1")
//                .roles("ADMIN", "USER")
//                .and()
//                .withUser("user")
//                .password("pwd")
//                .roles("USER");
        auth.jdbcAuthentication().dataSource(dataSource)
                .withDefaultSchema()
                .withUser("admin")
                .password("admin1")
                .roles("ADMIN", "USER")
                .and()
                .withUser("user")
                .password("pwd")
                .roles("USER");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
//    public PasswordEncoder getPasswordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }


