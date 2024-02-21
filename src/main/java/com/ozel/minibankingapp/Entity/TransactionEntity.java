package com.ozel.minibankingapp.Entity;

import static javax.persistence.GenerationType.SEQUENCE;

import com.ozel.minibankingapp.Model.Enum.TransactionStatusConverter;
import com.ozel.minibankingapp.Model.Enum.TransactionStatusEnum;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Setter
@Table(name = "transaction")
public class TransactionEntity {
  @Id
  @SequenceGenerator(
      name = "transaction_sequence",
      sequenceName = "transaction_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = SEQUENCE,
      generator = "workout_sequence"
  )
  @Column(
      name = "id",
      nullable = false,
      updatable = false
  )
  private Long id;

  @ManyToOne
  @JoinColumn(name = "from_account", foreignKey = @ForeignKey(name = "transaction_account_from_fk"), nullable = false)
  @ToString.Exclude
  private AccountEntity from;

  @ManyToOne
  @JoinColumn(name = "to_account", foreignKey = @ForeignKey(name = "transaction_account_to_fk"), nullable = false)
  @ToString.Exclude
  private AccountEntity to;

  @Column(name = "amount", columnDefinition = "DECIMAL", nullable = false)
  private BigDecimal amount;

  @CreationTimestamp
  @Column(name = "transaction_date", columnDefinition = "TIMESTAMP", nullable = false)
  private LocalDateTime transactionDate;

  @Column(
      name = "status",
      columnDefinition = "VARCHAR(255)",
      nullable = false
  )
  @Convert(converter = TransactionStatusConverter.class)
  private TransactionStatusEnum status = TransactionStatusEnum.FAILED;

}
