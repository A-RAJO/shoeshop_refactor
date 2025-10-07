package com.github.chore.repository.entity.inquiry;

import com.github.chore.repository.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "cs_inquiry")
@Entity
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cs_inquiry_id", nullable = false)
    private Integer inquiryId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 문의 작성자 아이디

    @Column(name = "name",nullable = false,length = 100)
    private String name;

    @Column(name="email",nullable = false, length = 100)
    private String email;

    @Column(name = "phone",nullable = false,length = 50)
    private String phone;

    @Column(name="title",nullable = false,length = 200)
    private String title;

    @Column(name = "context", nullable = false)
    private String context;

    @Column(name = "cs_status",nullable = false,length = 20)
    private String csStatus;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "mask_at", nullable = false)
    private LocalDateTime maskAt;

    @Column(name = "delete_at")
    private LocalDateTime deleteAt;

}
