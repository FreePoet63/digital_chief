package com.project.digital_chief.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.*;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Order(1)
@SecurityScheme(type = SecuritySchemeType.HTTP, name = "authenticated", scheme = "Basic", description = "Need auth")
public class SecurityConfig {
    @Bean
    protected SecurityFilterChain filterChain(final HttpSecurity http, final SecurityProperties props) throws Exception {
        return http
                .csrf().disable()
                .cors().disable()
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/authors/**", "/books/**").permitAll()
                                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    @Bean
    protected UserDetailsService userDetailsService(final PasswordEncoder passwordEncoder) {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("test")
                        .password("test")
                        .passwordEncoder(passwordEncoder::encode)
                        .roles("ADMIN")
                        .build()
        );
    }
}
