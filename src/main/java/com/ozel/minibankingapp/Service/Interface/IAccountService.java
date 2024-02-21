package com.ozel.minibankingapp.Service.Interface;

import com.ozel.minibankingapp.Dto.AccountRequestDto;
import com.ozel.minibankingapp.Dto.AccountResponseDto;
import com.ozel.minibankingapp.Dto.RetrieveAccountDto;
import com.ozel.minibankingapp.Dto.SearchAccountDto;
import java.util.List;
import java.util.UUID;

public interface IAccountService {

  AccountResponseDto createAccount(String username, AccountRequestDto accountRequestDto);

  List<RetrieveAccountDto> searchAccount(String username, SearchAccountDto accountRequestDto);


  AccountResponseDto updateAccount(String username, AccountRequestDto updateAccountRequestDto, UUID id);

  String deleteAccount(String username, UUID id);

  RetrieveAccountDto retrieveAccount(String username, UUID id);



}
