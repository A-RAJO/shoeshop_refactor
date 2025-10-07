package com.github.chore.repository.entity.cs_access_log;

import com.github.chore.repository.entity.inquiry.Inquiry;
import com.github.chore.repository.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "cs_access_log")
@Entity
public class CSAccessLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cs_access_log_id", nullable = false)
    private Integer CSAccessLogId;

    @ManyToOne
    @JoinColumn(name = "cs_inquiry_id",nullable = false)
    private Inquiry inquiry;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)  // user(admin)와 cs inquiry 간 중간 테이블
    private User adminId; // 관리자 아이디

    @Column(name = "accessed_at", nullable = false)
    private LocalDateTime accessedAt;
}
