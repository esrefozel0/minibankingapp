package com.ozel.minibankingapp.Entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(name = "username_unique", columnNames = "username")})
public class UserEntity {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
      name = "UUID",
      strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(updatable = false, nullable = false)
  private UUID id;

  @Column(name = "username", columnDefinition = "VARCHAR(255)", nullable = false)
  private String username;

  @Column(name = "password", columnDefinition = "VARCHAR(255)", nullable = false)
  private String password;

  @Column(name = "email", columnDefinition = "VARCHAR(255)", nullable = false)
  private String email;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "Timestamp", nullable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "Timestamp")
  private LocalDateTime updatedAt;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  @ToString.Exclude
  private List<AccountEntity> accountEntityList;
}
