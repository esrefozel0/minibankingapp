package com.ozel.minibankingapp.Service.Implementation;

import com.ozel.minibankingapp.Dto.LoginRequestDto;
import com.ozel.minibankingapp.Dto.LoginResponseDto;
import com.ozel.minibankingapp.Dto.RegisterDto;
import com.ozel.minibankingapp.Entity.UserEntity;
import com.ozel.minibankingapp.Repository.UserRepository;
import com.ozel.minibankingapp.Security.JWTGenerator;
import com.ozel.minibankingapp.Service.Interface.IAuthService;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {

  private final AuthenticationManager authenticationManager;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JWTGenerator jwtGenerator;

  @Override
  public LoginResponseDto login(LoginRequestDto loginRequestDto) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            loginRequestDto.getUsername(),
            loginRequestDto.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String token = jwtGenerator.generateToken(authentication);
    Optional<UserEntity> user =  userRepository.findByUsername(loginRequestDto.getUsername());
    return new LoginResponseDto(user.get(), token);
  }

  @Override
  public ResponseEntity<String> register(RegisterDto registerDto) {
    if (userRepository.existsByUsername(registerDto.getUsername())) {
      return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
    }
    UserEntity user = new UserEntity();
    user.setUsername(registerDto.getUsername());
    user.setPassword(passwordEncoder.encode((registerDto.getPassword())));
    user.setEmail(registerDto.getEmail());
    userRepository.save(user);
    return new ResponseEntity<>("username: "+registerDto.getUsername()+ " password : "+registerDto.getPassword(), HttpStatus.OK);
  }
}
