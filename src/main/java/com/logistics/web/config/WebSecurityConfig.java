package com.logistics.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static jakarta.servlet.DispatcherType.ERROR;
import static jakarta.servlet.DispatcherType.FORWARD;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private final DataSource dataSource;
    @Autowired
    public WebSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT empId, password FROM Employee WHERE customerId=?")
                .authoritiesByUsernameQuery("SELECT empId, role FROM Employee WHERE customerId=?");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(cs -> cs.disable())
                .authorizeHttpRequests(
                        (authz) -> authz
                                .dispatcherTypeMatchers(FORWARD, ERROR).permitAll()
                                .requestMatchers("/assets/**", "/index.html", "/", "/logout", "/login", "/register", "/carrier/**","/order/**","/product/**","/shipment/**").permitAll()
                                .requestMatchers("/customer/**","/invoice/**","/complaint/**").hasAnyAuthority("SA","A")
                                .requestMatchers("/employee/**").hasAuthority("SA")
                                .requestMatchers("/warehouse/**").hasAnyAuthority("SA","WM","A")
//                        .anyRequest().denyAll()
                ).formLogin((formlogin) ->  formlogin.loginPage("/login").permitAll())
                .logout(logout -> logout.logoutSuccessUrl("/").permitAll());

        return http.build();
    }
}
