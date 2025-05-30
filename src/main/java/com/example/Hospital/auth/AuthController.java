package com.example.Hospital.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins ="http://localhost:3000")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthService authService;
    
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse>login(@RequestBody LoginRequest request){  
        return ResponseEntity.ok(authService.login(request));
        
    }
    
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse>register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }
    
    
}
