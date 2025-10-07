package com.github.chore.repository.entity.seller;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.github.chore.repository.entity.seller.VerificationStatus.PENDING;
import static com.github.chore.repository.entity.seller.VerificationStatus.VERIFIED;

@Getter
@Setter
@Table(name = "seller_profile")
@Entity
public class Seller {
    @Id
    @Column(name = "seller_id",nullable = false)
    private Integer seller_id;

    @Column(name = "business_name", nullable = false, length = 100)
    private String businessName;

    @Column(name = "business_number", nullable = false, length = 50)
    private String businessNumber;

    @Column(name= "contact_person", nullable = false, length = 50)
    private String contactPerson;

    @Column(name = "businessPhone", nullable = false, length = 20)
    private String businessPhone;

    @Column(name = "businessEmail", nullable = false, length = 100)
    private String businessEmail;

    @Column(name = "bank_name", nullable = false, length = 50)
    private String bankName;

    @Column(name="account_number",nullable = false,length = 50)
    private String accountNumber;

    @Column(name = "account_holder",nullable = false,length = 50)
    private String accountHoler;

    
    @Enumerated(EnumType.STRING)
    @Column(name = "verification_status", nullable = false)
    private VerificationStatus verificationStatus = PENDING;

    
    @Column(name="is_approved",nullable = false)
    private Boolean isApproved = Boolean.valueOf(false);

    @Column(name = "approved_at",nullable = false)
    private LocalDate approvedAt;

    
    @Column(name = "total_orders")
    private Integer totalOrders = 0;

    @Column(name = "total_revenue")
    private BigDecimal totalRevenue;

    @Column(name = "rating_avg")
    private BigDecimal ratingAvg;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

}
