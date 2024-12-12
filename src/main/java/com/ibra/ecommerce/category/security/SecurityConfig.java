//package com.ibra.ecommerce.category.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//
//    @Autowired
//    DataSource dataSource;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity (not recommended for production)
//                .authorizeHttpRequests(auth -> auth
////                                .requestMatchers("/api/admin").hasRole("ADMIN")
////                                .requestMatchers("/api/user").hasAnyRole("USER", "ADMIN")
////                                .requestMatchers("/api/public/**").permitAll()
////                                .requestMatchers("h2-console/**").permitAll()
//                                .anyRequest().authenticated()
////                        .anyRequest().hasRole("ADMIN")
//                )
//                .httpBasic(withDefaults())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()));
//        return http.build();
//    }
//
//
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails user = User.builder()
//                .username("user")
//                .password(passwordEncoder.encode("userpass")) // Use BCrypt for encoding
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder.encode("adminpass")) // Use BCrypt for encoding
//                .roles("ADMIN")
//                .build();
//
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//        userDetailsManager.createUser(user);
//        userDetailsManager.createUser(admin);
//
////        return new InMemoryUserDetailsManager(user, admin);
//        return userDetailsManager;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(); // BCrypt for secure password encoding
//    }
//
//}