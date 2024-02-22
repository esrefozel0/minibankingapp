package com.ozel.minibankingapp.Service.Interface;

import com.ozel.minibankingapp.Dto.RetrieveTransactionDto;
import com.ozel.minibankingapp.Dto.TransferMoneyDto;
import com.ozel.minibankingapp.Exceptions.AccountDoesNotExist;
import com.ozel.minibankingapp.Exceptions.UserDoesNotExist;
import com.ozel.minibankingapp.Exceptions.UsersAccountDoesNotExist;
import java.util.List;
import java.util.UUID;

public interface ITransactionService {

  RetrieveTransactionDto transferMoney(String username, TransferMoneyDto transferMoneyDto)
      throws UserDoesNotExist, AccountDoesNotExist, UsersAccountDoesNotExist;

  List<RetrieveTransactionDto> retrieveHistory(String username, UUID accountId)
      throws UserDoesNotExist, UsersAccountDoesNotExist;

}
