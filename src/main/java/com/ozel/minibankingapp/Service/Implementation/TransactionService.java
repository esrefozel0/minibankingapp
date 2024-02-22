package com.ozel.minibankingapp.Service.Implementation;

import com.ozel.minibankingapp.Dto.RetrieveTransactionDto;
import com.ozel.minibankingapp.Dto.TransferMoneyDto;
import com.ozel.minibankingapp.Entity.AccountEntity;
import com.ozel.minibankingapp.Entity.TransactionEntity;
import com.ozel.minibankingapp.Entity.UserEntity;
import com.ozel.minibankingapp.Exceptions.AccountDoesNotExist;
import com.ozel.minibankingapp.Exceptions.UserDoesNotExist;
import com.ozel.minibankingapp.Exceptions.UsersAccountDoesNotExist;
import com.ozel.minibankingapp.Model.Enum.TransactionStatusEnum;
import com.ozel.minibankingapp.Repository.AccountRepository;
import com.ozel.minibankingapp.Repository.TransactionRepository;
import com.ozel.minibankingapp.Repository.UserRepository;
import com.ozel.minibankingapp.Service.Interface.ITransactionService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionService implements ITransactionService {

  private final UserRepository userRepository;
  private final AccountRepository accountRepository;
  private final TransactionRepository transactionRepository;

  @Override
  @Transactional
  public RetrieveTransactionDto transferMoney(String username, TransferMoneyDto transferMoneyDto)
      throws UserDoesNotExist, AccountDoesNotExist, UsersAccountDoesNotExist {
    Optional<AccountEntity> fromAccount = accountRepository.findByUser_UsernameAndNumber(username, transferMoneyDto.getFromAccountNumber());
    Optional<AccountEntity> toAccount = accountRepository.findByNumber(transferMoneyDto.getToAccountNumber());
    this.getUserEntity(username).getAccountEntityList().stream().filter(acc -> acc.getNumber().equals(transferMoneyDto.getFromAccountNumber())).findFirst().orElseThrow(() -> new UsersAccountDoesNotExist("Users account not found"));
    if (toAccount.isEmpty() || fromAccount.isEmpty()) {
      throw new AccountDoesNotExist("Account Not Found");
    }
    TransactionEntity transaction = new TransactionEntity();
    transaction.setFrom(fromAccount.get());
    transaction.setTo(toAccount.get());
    transaction.setStatus(TransactionStatusEnum.SUCCESS);
    transaction.setAmount(transferMoneyDto.getAmount());
    transactionRepository.save(transaction);
    BigDecimal fromBalance = fromAccount.get().getBalance();
    fromAccount.get().setBalance(fromBalance.subtract(transferMoneyDto.getAmount()));
    BigDecimal toBalance = toAccount.get().getBalance();
    toAccount.get().setBalance(toBalance.add(transferMoneyDto.getAmount()));

    return new RetrieveTransactionDto(transaction);
  }

  @Override
  public List<RetrieveTransactionDto> retrieveHistory(String username, UUID accountId)
      throws UserDoesNotExist, UsersAccountDoesNotExist {
    UserEntity user = getUserEntity(username);
    user.getAccountEntityList().stream().filter(account -> account.getId().equals(accountId)).findFirst().orElseThrow(() -> new UsersAccountDoesNotExist("Users account not found"));
    List<TransactionEntity> transactionList = transactionRepository.findAllByFrom_IdOrTo_Id(accountId, accountId);
    return transactionList.stream().map(
        RetrieveTransactionDto::new).toList();
  }

  private UserEntity getUserEntity(String username) throws UserDoesNotExist {
    return userRepository.findByUsername(username).orElseThrow(() -> new UserDoesNotExist("User not found"));
  }

}
