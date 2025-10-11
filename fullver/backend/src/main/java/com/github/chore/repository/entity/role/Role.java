package com.github.chore.repository.entity.role;

import com.github.chore.repository.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "role_id", nullable = false)
  private Integer roleId;

  @Enumerated(EnumType.STRING)
  @Column(name = "role_type", nullable = false, length = 20)
  private RoleType roleType;

}


