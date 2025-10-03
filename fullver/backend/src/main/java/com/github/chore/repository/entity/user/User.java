package com.github.chore.repository.entity.user;

import com.github.chore.repository.entity.role.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @OneToOne
    @JoinColumn(name="role_id",nullable = false)
    private Role role;

    @Column(name = "user_name", nullable = false, length = 20)
    private String userName;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name="password", nullable = false, length = 500) // 해시값 저장 예정 : 20->500
    private String password;

    @Column(name = "phone_num", nullable = false, length = 20)
    private String phoneNum;

    @Column(name = "user_address", nullable = false, length = 300)
    private String userAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name="user_img",nullable = false, length = 500)
    private String userImg;

    @Column(name="is_active",nullable = false)
    private boolean isActive;

    @Column(name = "created_at", nullable = false, updatable = false) // 자동 입력 기능 필요 : @LastModifiedDate와 Auditing 설정
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
