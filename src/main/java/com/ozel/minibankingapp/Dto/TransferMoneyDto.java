package com.ozel.minibankingapp.Dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferMoneyDto {

  private String fromAccountNumber;
  private String toAccountNumber;
  private BigDecimal amount;

}
