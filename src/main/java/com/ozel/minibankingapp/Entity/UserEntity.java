package com.ozel.minibankingapp.Entity;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@Setter
@Table(name = "users")
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

}
