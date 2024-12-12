//package com.ibra.ecommerce.user.security;
//
//import com.ibra.ecommerce.user.service.UserCustomDetailsService;
//import com.ibra.ecommerce.user.service.UserServiceImp;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@RequiredArgsConstructor
//public class SecurityConfig {
//    private final JwtUtil jwtUtil;
//    @Autowired
//    private final UserCustomDetailsService userService;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/register", "/api/login").permitAll()
//                        .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN")
//                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
//                        .anyRequest().authenticated())
//                .addFilter(new JwtAuthenticationFilter(authenticationManager(null), jwtUtil))
//                .addFilterAfter(new JwtAuthorizationFilter(jwtUtil, (UserDetailsService) userService), JwtAuthenticationFilter.class);
//
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//        return configuration.getAuthenticationManager();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
