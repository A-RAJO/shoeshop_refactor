package com.github.chore.repository.entity.user;

import com.github.chore.repository.entity.role.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer userId;

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
    @Column(name = "gender")
    private Gender gender = Gender.NONE;

    @Column(name="user_img",nullable = false, length = 500)
    private String userImg;

    @Column(name="is_active",nullable = false)
    private boolean isActive = true;

    @Column(name = "created_at", insertable = false, updatable = false) //insertable = false 설정하지 않으면 DB에서 자동입력 안됨
    private LocalDateTime createdAt;

    @Column(name = "updated_at",  insertable = false)
    private LocalDateTime updatedAt;
}
