package dmacc.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import dmacc.beans.UserDetailsServiceImplementation;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
    private JwtAuthEntryPoint authEntryPoint;

    private final UserDetailsServiceImplementation userDetailsService;

    public SecurityConfig(UserDetailsServiceImplementation userDetailsService) {
        this.userDetailsService = userDetailsService;
        this.authEntryPoint = authEntryPoint;

    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> 
                authorize
                .requestMatchers("/login", "/css/**", "/register").permitAll()
                .requestMatchers("/register","/css/**" ).permitAll() // Allow access to /register
                .anyRequest().authenticated()
            )
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/login") // Specify custom login page
                    .permitAll() // Allow everyone to access the login page
            )
            .logout(logout ->
                logout
                    .permitAll()
            );
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public AuthenticationSuccessHandler successHandler() {
        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
        handler.setDefaultTargetUrl("/index"); 
        return handler;
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public  JWTAuthenticationFilter jwtAuthenticationFilter() {
        return new JWTAuthenticationFilter();
    }
}
