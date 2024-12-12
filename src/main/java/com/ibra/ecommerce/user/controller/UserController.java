//package com.ibra.ecommerce.user.controller;
//
//import com.ibra.ecommerce.user.AuthReqRes.AuthRequest;
//import com.ibra.ecommerce.user.AuthReqRes.AuthResponse;
//import com.ibra.ecommerce.user.security.JwtUtil;
//import com.ibra.ecommerce.user.userDto.UserDTO;
//import com.ibra.ecommerce.user.service.UserServiceImp;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//public class UserController {
//    private final UserServiceImp userService;
//    private final AuthenticationManager authenticationManager;
//    private final JwtUtil jwtUtil;
//
//
//    public UserController(UserServiceImp userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
//        this.userService = userService;
//        this.authenticationManager = authenticationManager;
//        this.jwtUtil = jwtUtil;
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
//        userService.registerUser(userDTO);
//        return ResponseEntity.ok("User registered successfully");
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
////        // Authenticate the user
////        Authentication authentication = authenticationManager.authenticate(
////                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
////
////        // Generate JWT token
////        String username = authentication.getName();
////        var user = userService.loadUserByUsername(username);
////        String token = jwtUtil.generateToken(username, user.getRoles());
//
//        // Return the token as response
////        return ResponseEntity.ok(new AuthResponse(token));
//
//        return ResponseEntity.status(HttpStatus.OK).body("abc");
//    }
//
//    @GetMapping("/admin")
//    public ResponseEntity<String> adminEndpoint() {
//        return ResponseEntity.ok("Welcome, Admin!");
//    }
//
//    @GetMapping("/user")
//    public ResponseEntity<String> userEndpoint() {
//        return ResponseEntity.ok("Welcome, User!");
//    }
//}
//
