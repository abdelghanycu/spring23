package com.sci.spring23.controllers;

import com.sci.spring23.dto.ERole;
import com.sci.spring23.dto.request.JwtRequest;
import com.sci.spring23.dto.response.JwtResponse;
import com.sci.spring23.models.User;
import com.sci.spring23.security.UserDetailsImpl;
import com.sci.spring23.services.AuthService;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("/login")
  public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
    return ResponseEntity.ok(authService.login(request));
  }

  @PostMapping("/register")
  public ResponseEntity<JwtResponse> register(@RequestBody JwtRequest request) {
    return ResponseEntity.ok(authService.register(request));
  }
}
