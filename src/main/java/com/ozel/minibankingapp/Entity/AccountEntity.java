package com.ozel.minibankingapp.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@Setter
@Table(name = "account", uniqueConstraints = {
    @UniqueConstraint(name = "number_unique", columnNames = "number"),
    @UniqueConstraint(name = "name_unique", columnNames = "name")})
public class AccountEntity {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
      name = "UUID",
      strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(updatable = false, nullable = false)
  private UUID id;

  @Column(name = "number", columnDefinition = "VARCHAR(255)", nullable = false)
  private String number;

  @Column(name = "name", columnDefinition = "VARCHAR(255)", nullable = false)
  private String name;

  @Column(name = "balance", columnDefinition = "DECIMAL", nullable = false)
  private BigDecimal balance;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
  private LocalDateTime updatedAt;

  @ManyToOne
  @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "account_user_fk"), nullable = false)
  @ToString.Exclude
  private UserEntity user;

}
