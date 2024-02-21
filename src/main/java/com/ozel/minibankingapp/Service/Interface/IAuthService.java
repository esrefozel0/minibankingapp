package com.ozel.minibankingapp.Service.Interface;

import com.ozel.minibankingapp.Dto.LoginDto;
import com.ozel.minibankingapp.Dto.RegisterDto;
import org.springframework.http.ResponseEntity;

public interface IAuthService {

  String login(LoginDto loginDto);

  ResponseEntity<String> register(RegisterDto registerDto);
}
