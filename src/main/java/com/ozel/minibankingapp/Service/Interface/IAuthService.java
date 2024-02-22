package com.ozel.minibankingapp.Service.Interface;

import com.ozel.minibankingapp.Dto.LoginRequestDto;
import com.ozel.minibankingapp.Dto.LoginResponseDto;
import com.ozel.minibankingapp.Dto.RegisterDto;
import org.springframework.http.ResponseEntity;

public interface IAuthService {

  LoginResponseDto login(LoginRequestDto loginRequestDto);

  ResponseEntity<String> register(RegisterDto registerDto);
}
