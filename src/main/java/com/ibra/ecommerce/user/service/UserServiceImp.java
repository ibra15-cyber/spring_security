//package com.ibra.ecommerce.user.service;
//
//import com.ibra.ecommerce.user.model.User;
//import com.ibra.ecommerce.user.userDto.UserDTO;
//import com.ibra.ecommerce.user.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@Transactional
//public class UserServiceImp implements UserCustomDetailsService {
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public void registerUser(UserDTO userDTO) {
//        // Check if the username or email already exists
//        Optional<User> existingUserByUsername = userRepository.findByUsername(userDTO.getUsername());
//        Optional<User> existingUserByEmail = userRepository.findByEmail(userDTO.getEmail());
//
//        if (existingUserByUsername.isPresent() || existingUserByEmail.isPresent()) {
//            throw new RuntimeException("Username or Email already exists");
//        }
//
//        // Create and save the user
//        User user = new User();
//        user.setUsername(userDTO.getUsername());
//        user.setEmail(userDTO.getEmail());
//        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
//        user.setRoles(userDTO.getRoles());
//
//        userRepository.save(user);
//    }
//
//
//    @Override
//    public User loadUserByUsername(String username) {
//        return userRepository.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//    }
//}
//
