package com.github.chore.repository.entity.cart;

import com.github.chore.repository.entity.shoe_option.ShoeOption;
import com.github.chore.repository.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cart")
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", nullable = false) //auto-incresment로 설정되어 있어 길이제약 없음
    private Integer cartId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shoe_option_id", nullable = false)
    private ShoeOption shoeOption;

    @Column(name="quantity",nullable = false)
    private Integer quantity;

    @Column(name = "created_at", nullable = false, updatable = false) // 자동 입력 기능 필요 : @LastModifiedDate와 Auditing 설정
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updatedAt;
}
