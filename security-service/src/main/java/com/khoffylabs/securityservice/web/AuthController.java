package com.khoffylabs.securityservice.web;

import com.khoffylabs.securityservice.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/token")
    public ResponseEntity<Map<String, String>> jwtToken(
            String grantType, String username, String password, boolean withRefreshToken, String refreshToken) {

        ResponseEntity<Map<String, String>> responseEntity;
        Map<String, String> idToken =
                authService.jwtToken(grantType, username, password, withRefreshToken, refreshToken);
        if(idToken.containsKey("errorMessage")) {
            responseEntity = new ResponseEntity<>(idToken, HttpStatus.UNAUTHORIZED);
        } else {
            responseEntity = new ResponseEntity<>(idToken, HttpStatus.OK);
        }
        return responseEntity;
    }
}

