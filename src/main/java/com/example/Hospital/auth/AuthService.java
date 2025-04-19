
package com.example.Hospital.auth;

import com.example.Hospital.Jwt.JwtService;
import com.example.Hospital.User.Role;
import com.example.Hospital.User.User;
import com.example.Hospital.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AuthService {
    
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    public AuthResponse login(LoginRequest request){
        return null;
    }
    
      public AuthResponse register(RegisterRequest request){
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .country(request.getCountry())
                .role(Role.USER)
                .build();
        userRepository.save(user);
        
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
