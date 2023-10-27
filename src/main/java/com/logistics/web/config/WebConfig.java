package com.logistics.web.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
@Configuration
@EnableWebSecurity
public class webConfig {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    private DataSource dataSource;
     
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password ,'true' as enabled from User where username=?")
            .authoritiesByUsernameQuery("select username, authority  from User where username=?")
        ;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((requests) -> {
                            requests.requestMatchers("/resources/**","/static/**","/css/**", "/js/**","/images/**", "/webjars/**", "/assests/**","/index.html", "/", "/logout","/logIn","/signUp").permitAll();
                            requests.requestMatchers("/error").permitAll();
                            requests.requestMatchers("/customer/**","/invoice/**","/complaint/**").hasAnyAuthority("SA","A");
                            requests.requestMatchers("/employee/**").hasAuthority("SA");
                            requests.requestMatchers("/warehouse/**").hasAnyAuthority("SA","WM","A");
                            requests.anyRequest().authenticated();
                        }
                )
                .formLogin((form) ->form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .successForwardUrl("/login_success_handler")
                        .failureForwardUrl("/login_failure_handler")
                        .permitAll()
                )
                .logout((logout) -> logout
                .logoutUrl("/logout") 
                .logoutSuccessUrl("/login") 
                .permitAll());
        return http.build();
    }
    
}
