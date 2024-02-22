package com.ozel.minibankingapp.Dto;

import com.ozel.minibankingapp.Entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {

  private String username;
  private String email;
  private String token;

  public LoginResponseDto(UserEntity userEntity, String token){
    setUsername(userEntity.getUsername());
    setEmail(userEntity.getEmail());
    setToken(token);
  }
}
