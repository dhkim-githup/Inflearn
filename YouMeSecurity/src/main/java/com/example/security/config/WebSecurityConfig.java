package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/","/login","/join").permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()
                );

        http
                .formLogin((form) -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/loginProc")
                        .permitAll()
                );

        http
                .logout((logout) -> logout.permitAll()
                );

        http
                .sessionManagement((session) -> session
                        .maximumSessions(1)
                        .maxSessionsPreventsLogin(false)
                )
        ;

        http
                .csrf((auth) -> auth.disable());

        return http.build();
    }

    // InMemory 방식 사용
    /*
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                        .username("user")
                        .password(bCryptPasswordEncoder().encode("1234"))
                        .roles("USER")
                        .build();

        UserDetails user2 =User.builder()
                        .username("admin")
                        .password(bCryptPasswordEncoder().encode("1234"))
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(user,user2);
    }
    */
}
