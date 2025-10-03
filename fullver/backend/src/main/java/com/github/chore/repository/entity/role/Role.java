package com.github.chore.repository.entity.role;

import com.github.chore.repository.entity.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "role") // 테이블 이름
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "role_id", nullable = false)
  private Integer roleId;

  @Enumerated(EnumType.STRING)
  @Column(name = "role_type", nullable = false, length = 20)
  private RoleType roleType;

  @OneToOne
  @JoinColumn(name="user_id",nullable = false)
  private User user;
}


