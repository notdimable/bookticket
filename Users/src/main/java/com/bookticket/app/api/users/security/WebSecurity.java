package com.bookticket.app.api.users.security;


import com.bookticket.app.api.users.service.interfaces.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurity {

    private final Environment environment;
    private final UserService userService;


    public WebSecurity(Environment environment, UserService userService) {
        this.environment = environment;
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {

        AuthenticationFilter authenticationFilter =
                new AuthenticationFilter(userService, environment, authManager);

        String loginPath = environment.getProperty("login.url.path");

        authenticationFilter.setFilterProcessesUrl(loginPath);

        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users/login", "/users/register").permitAll()
                        .requestMatchers("/users/users/login").permitAll() // разрешить доступ к логину
                        .requestMatchers("/actuator/health").permitAll() // публичный health endpoint
                        .requestMatchers("/actuator/**").hasRole("ADMIN") // остальные actuator доступны только ADMIN
                        .anyRequest().authenticated()
                )
                .addFilter(authenticationFilter);

        // Другие фильтры, например AuthorizationFilter, добавляй аналогично

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}