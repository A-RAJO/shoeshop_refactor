package com.github.chore.repository.entity.shoe_review;

import com.github.chore.repository.entity.option_shoe_list.OrderShoeList;
import com.github.chore.repository.entity.shoe.Shoe;
import com.github.chore.repository.entity.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "shoe_review")
public class ShoeReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", nullable = false)
    private Integer reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shoe_id", nullable = false)
    private Shoe shoe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_shoe_list_id", nullable = false)
    private OrderShoeList orderShoeList;

    @Column(name = "rating", nullable = false)
    private Integer rating;  // 체크 제약조건은 애플리케이션 레벨에서 validation 가능

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "is_verified")
    private Boolean verified = false;

    @Column(name = "is_photo_review")
    private Boolean photoReview = false;

    @Column(name = "helpful_count")
    private Integer helpfulCount = 0;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}