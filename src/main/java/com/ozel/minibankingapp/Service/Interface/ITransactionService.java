package com.ozel.minibankingapp.Service.Interface;

import com.ozel.minibankingapp.Dto.RetrieveTransactionDto;
import com.ozel.minibankingapp.Dto.TransferMoneyDto;
import java.util.List;
import java.util.UUID;

public interface ITransactionService {

  RetrieveTransactionDto transferMoney(String username, TransferMoneyDto transferMoneyDto) throws Exception;

  List<RetrieveTransactionDto> retrieveHistory(String username, UUID accountId);

}
