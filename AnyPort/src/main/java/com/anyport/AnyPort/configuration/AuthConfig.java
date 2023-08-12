package com.anyport.AnyPort.configuration;

import com.anyport.AnyPort.configJWT.JWTTockenGeneratorFilter;
import com.anyport.AnyPort.configJWT.JWTValidationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class AuthConfig {

    @Bean
    public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {

        http
//                .cors()
//               here we are telling that dont create or use jsession id and use jwt
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, "/customer/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/customer/calculatePrice").permitAll()
                .antMatchers(HttpMethod.POST, "/rider/createNewRider").permitAll()
//
                .antMatchers(HttpMethod.GET, "/customer/all/*").hasAnyRole("ADMIN","CUSTOMER")
                .antMatchers(HttpMethod.GET, "/rider/all/*").hasAnyRole("ADMIN","RIDER")
                .anyRequest().authenticated()
                .and()
//                the filter which are created by us putting in between existing filters
                .addFilterAfter(new JWTTockenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JWTValidationFilter(), BasicAuthenticationFilter.class)

                .formLogin()
                .and()
                .httpBasic();

        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }







}
