package com.ozel.minibankingapp.Repository;

import com.ozel.minibankingapp.Entity.AccountEntity;
import java.util.Optional;
import java.util.UUID;
import javax.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {

  Boolean existsByNumber(String number);
  @Lock(value = LockModeType.PESSIMISTIC_WRITE)
  Optional<AccountEntity> findByUser_UsernameAndNumber(String username, String number);

  @Lock(value = LockModeType.PESSIMISTIC_WRITE)
  Optional<AccountEntity> findByNumber(String number);

}
