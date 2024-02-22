package com.ozel.minibankingapp.Service.Implementation;

import com.ozel.minibankingapp.Dto.AccountRequestDto;
import com.ozel.minibankingapp.Dto.AccountResponseDto;
import com.ozel.minibankingapp.Dto.RetrieveAccountDto;
import com.ozel.minibankingapp.Dto.SearchAccountDto;
import com.ozel.minibankingapp.Entity.AccountEntity;
import com.ozel.minibankingapp.Entity.UserEntity;
import com.ozel.minibankingapp.Exceptions.UserDoesNotExist;
import com.ozel.minibankingapp.Exceptions.UsersAccountDoesNotExist;
import com.ozel.minibankingapp.Repository.AccountRepository;
import com.ozel.minibankingapp.Repository.UserRepository;
import com.ozel.minibankingapp.Service.Interface.IAccountService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService implements IAccountService {

  private final UserRepository userRepository;
  private final AccountRepository accountRepository;

  @Override
  public AccountResponseDto createAccount(String username, AccountRequestDto accountRequestDto)
      throws UserDoesNotExist {
    UserEntity user = getUserEntity(username);
    AccountEntity account = new AccountEntity();
    account.setName(accountRequestDto.getName());
    account.setUser(user);
    account.setNumber(generateAccountNumber());
    account.setBalance(BigDecimal.ZERO);
    accountRepository.save(account);
    return new AccountResponseDto(account);
  }

  @Override
  public List<RetrieveAccountDto> searchAccount(String username,
      SearchAccountDto searchAccountDto) throws UserDoesNotExist {
    UserEntity user = getUserEntity(username);
    return user.getAccountEntityList().stream().filter(acc -> acc.getName().contains(searchAccountDto.getName()) && acc.getNumber().contains(searchAccountDto.getNumber())).map(
        RetrieveAccountDto::new).toList();
  }


  public AccountResponseDto updateAccount(String username, AccountRequestDto updateAccountRequestDto, UUID id)
      throws UsersAccountDoesNotExist, UserDoesNotExist {
    AccountEntity account = getAccount(id, username);
    account.setName(updateAccountRequestDto.getName());
    accountRepository.save(account);
    return new AccountResponseDto(account);
  }

  @Override
  public String deleteAccount(String username, UUID id)
      throws UsersAccountDoesNotExist, UserDoesNotExist {
    AccountEntity account = getAccount(id, username);
    accountRepository.delete(account);
    return id + " account deleted";
  }


  @Override
  public RetrieveAccountDto retrieveAccount(String username, UUID id)
      throws UsersAccountDoesNotExist, UserDoesNotExist {
    AccountEntity account = getAccount(id, username);
    return new RetrieveAccountDto(account);
  }

  private AccountEntity getAccount(UUID id, String username)
      throws UsersAccountDoesNotExist, UserDoesNotExist {
    UserEntity user = this.getUserEntity(username);
    return user.getAccountEntityList().stream().filter(acc -> acc.getId().equals(
        id)).findFirst().orElseThrow(() -> new UsersAccountDoesNotExist("Users Account Does Not Exists"));
  }

  private UserEntity getUserEntity(String username) throws UserDoesNotExist {
    return userRepository.findByUsername(username).orElseThrow(() -> new UserDoesNotExist("Users Account Does Not Exists"));
  }

  private String generateAccountNumber(){
    Random rand = new Random();
    StringBuilder number = new StringBuilder();
    for (int i = 0; i < 16; i++)
    {
      int n = rand.nextInt(10);
      number.append(n);
    }
    if(accountRepository.existsByNumber(number.toString())){
      return generateAccountNumber();
    }
    return number.toString();
  }
}
