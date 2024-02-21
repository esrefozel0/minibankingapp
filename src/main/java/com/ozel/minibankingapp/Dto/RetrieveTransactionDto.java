package com.ozel.minibankingapp.Dto;

import com.ozel.minibankingapp.Entity.TransactionEntity;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetrieveTransactionDto {

  private Long id;
  private String fromAccountNumber;
  private String toAccountNumber;
  private BigDecimal amount;

  public RetrieveTransactionDto(TransactionEntity transaction){
    setId(transaction.getId());
    setFromAccountNumber(transaction.getFrom().getNumber());
    setToAccountNumber(transaction.getTo().getNumber());
    setAmount(transaction.getAmount());
  }
}
