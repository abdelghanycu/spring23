package com.sci.spring23.services;

import com.sci.spring23.dto.ERole;
import com.sci.spring23.dto.request.JwtRequest;
import com.sci.spring23.dto.response.JwtResponse;
import com.sci.spring23.models.User;
import com.sci.spring23.repo.RoleRepository;
import com.sci.spring23.repo.UserRepository;
import com.sci.spring23.security.JwtTokenUtil;
import com.sci.spring23.security.UserDetailsImpl;
import com.sci.spring23.security.UserDetailsServiceImpl;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final AuthenticationManager authenticationManager;
  private final JwtTokenUtil jwtTokenUtil;
  private final UserDetailsServiceImpl userDetailsService;
  private final UserRepository userRepo;
  private final RoleRepository roleRepository;
  private final BCryptPasswordEncoder passwordEncoder;


  public JwtResponse login(JwtRequest request) {

    final Authentication auth = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
    );
    SecurityContextHolder.getContext().setAuthentication(auth);
    UserDetailsImpl user = (UserDetailsImpl) userDetailsService.loadUserByUsername(
        request.getUsername());

    return new JwtResponse(jwtTokenUtil.addAuthentication(user));
  }

  public JwtResponse register(JwtRequest request) {
    User user = new User(null, request.getUsername(), passwordEncoder.encode(request.getPassword()),
        Collections.singleton(roleRepository.findByName(ERole.ROLE_USER)));
    userRepo.save(user);
    return login(request);
  }


}
