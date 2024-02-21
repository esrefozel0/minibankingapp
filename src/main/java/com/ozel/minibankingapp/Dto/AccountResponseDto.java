package com.ozel.minibankingapp.Dto;

import com.ozel.minibankingapp.Entity.AccountEntity;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountResponseDto {

  private UUID id;
  private String name;
  private String number;

  public AccountResponseDto(AccountEntity account){
    setId(account.getId());
    setName(account.getName());
    setNumber(account.getNumber());
  }
}
