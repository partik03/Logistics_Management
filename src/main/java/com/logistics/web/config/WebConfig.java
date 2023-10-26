package com.logistics.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;

import static jakarta.servlet.DispatcherType.ERROR;
import static jakarta.servlet.DispatcherType.FORWARD;

@Configuration
@EnableWebSecurity
public class WebConfig {
    private final DataSource dataSource;
    @Autowired
    public WebConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler(){
        return new AppAuthenticationSuccessHandler();
    }
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, userId as enabled FROM User where username=?")
                .authoritiesByUsernameQuery("SELECT username, authority FROM User WHERE username=?");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(cs -> cs.disable())
                .authorizeHttpRequests(
                        (authz) -> authz
                                .dispatcherTypeMatchers(FORWARD, ERROR).permitAll()
                                .requestMatchers("/**").permitAll()
//                                .requestMatchers("/resources/**","/static/**","/css/**", "/js/**","/images/**", "/webjars/**", "/assests/**","/index.html", "/", "/logout", "/dashboard", "/signUp", "/carrier","/order/**","/product/**","/shipment/**").permitAll()
//                                .requestMatchers("/customer/**","/invoice/**","/complaint/**").hasAnyAuthority("SA","A")
//                                .requestMatchers("/employee/**").hasAuthority("SA")
//                                .requestMatchers("/warehouse/**").hasAnyAuthority("SA","WM","A")
//                        .anyRequest().denyAll()
                ).formLogin((formlogin) ->  formlogin.loginPage("/login").loginProcessingUrl("/login").successHandler(appAuthenticationSuccessHandler()).permitAll())
                .logout(logout -> logout.logoutSuccessUrl("/").permitAll());

        return http.build();
    }
}
