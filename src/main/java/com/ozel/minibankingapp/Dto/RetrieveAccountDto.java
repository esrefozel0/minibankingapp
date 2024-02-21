package com.ozel.minibankingapp.Dto;

import com.ozel.minibankingapp.Entity.AccountEntity;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetrieveAccountDto {

  private UUID id;
  private String name;
  private String number;
  private BigDecimal balance;

  public RetrieveAccountDto(AccountEntity account){
    setId(account.getId());
    setName(account.getName());
    setNumber(account.getNumber());
    setBalance(account.getBalance());
  }
}
