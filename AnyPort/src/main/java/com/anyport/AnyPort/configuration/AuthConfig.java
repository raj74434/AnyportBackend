package com.anyport.AnyPort.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class AuthConfig {

    @Bean
    public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {

        http
                .csrf() .and().cors().disable()
                .authorizeHttpRequests()
//                .requestMatchers(HttpMethod.POST,"/ApI")
                .antMatchers(HttpMethod.POST, "/signup")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();

        return http.build();





//

//                here we disabled cors
//                .cors().and().csrf().disable()
//
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic();
//
//        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }




}