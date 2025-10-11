package com.github.chore.repository.entity.user_role;

import com.github.chore.repository.entity.role.Role;
import com.github.chore.repository.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_role")
@Entity
public class user_role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id",nullable = false)
    private Integer userRoleId;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false)
    private Role role;

}
