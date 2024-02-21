package com.ozel.minibankingapp.Repository;

import com.ozel.minibankingapp.Entity.TransactionEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

  List<TransactionEntity> findAllByFrom_IdOrTo_Id(UUID fromId, UUID toId);
}
