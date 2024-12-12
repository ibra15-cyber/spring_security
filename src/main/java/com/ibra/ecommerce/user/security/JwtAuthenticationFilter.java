//package com.ibra.ecommerce.user.security;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.ibra.ecommerce.user.AuthReqRes.AuthRequest;
//import com.ibra.ecommerce.user.AuthReqRes.AuthResponse;
//import jakarta.servlet.FilterChain;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//@RequiredArgsConstructor
//public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    private final AuthenticationManager authenticationManager;
//    private final JwtUtil jwtUtil;
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
//            throws AuthenticationException {
//        try {
//            AuthRequest authRequest = new ObjectMapper().readValue(request.getInputStream(), AuthRequest.class);
//            UsernamePasswordAuthenticationToken token =
//                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
//            return authenticationManager.authenticate(token);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
//                                            FilterChain chain, Authentication authResult) throws IOException {
//        String username = authResult.getName();
//        var roles = authResult.getAuthorities().stream()
//                .map(grantedAuthority -> grantedAuthority.getAuthority())
//                .toList();
//        String token = jwtUtil.generateToken(username, roles);
//        response.getWriter().write(new ObjectMapper().writeValueAsString(new AuthResponse(token)));
//        response.getWriter().flush();
//    }
//}
//
