package com.ozel.minibankingapp.Service.Interface;

import com.ozel.minibankingapp.Dto.AccountRequestDto;
import com.ozel.minibankingapp.Dto.AccountResponseDto;
import com.ozel.minibankingapp.Dto.RetrieveAccountDto;
import com.ozel.minibankingapp.Dto.SearchAccountDto;
import com.ozel.minibankingapp.Exceptions.UserDoesNotExist;
import com.ozel.minibankingapp.Exceptions.UsersAccountDoesNotExist;
import java.util.List;
import java.util.UUID;

public interface IAccountService {

  AccountResponseDto createAccount(String username, AccountRequestDto accountRequestDto)
      throws UserDoesNotExist;

  List<RetrieveAccountDto> searchAccount(String username, SearchAccountDto accountRequestDto)
      throws UserDoesNotExist;


  AccountResponseDto updateAccount(String username, AccountRequestDto updateAccountRequestDto, UUID id)
      throws UsersAccountDoesNotExist, UserDoesNotExist;

  String deleteAccount(String username, UUID id) throws UsersAccountDoesNotExist, UserDoesNotExist;

  RetrieveAccountDto retrieveAccount(String username, UUID id)
      throws UsersAccountDoesNotExist, UserDoesNotExist;



}
