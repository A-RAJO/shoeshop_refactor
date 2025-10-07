package com.github.chore.repository.entity.shoe;

import com.github.chore.repository.entity.category.Category;
import com.github.chore.repository.entity.shoe_detail.ShoeDetail;
import com.github.chore.repository.entity.seller.Seller;
import com.github.chore.repository.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "shoe")
@NoArgsConstructor
@Entity
public class Shoe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shoe_id", nullable = false)
    private Integer shoeId;

    @OneToOne
    @JoinColumn(name = "shoe_detail_id", nullable = false) // shoe_detail과 일대일, shoe_option과 일대다 관계
    private ShoeDetail shoeDetail;

    @Column(name = "price", nullable = false)
    private BigDecimal Price;

    @Column(name = "shoe_name",nullable = false) // 255자는 비활성화됨 왜?
    private String shoeName;

    @ManyToOne
    @JoinColumn(name="seller_id",nullable = false)
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "total_sales")
    private BigDecimal totalSales;

    @Column(name = "discount_price")
    private BigDecimal discountPrice;

    @Column(name = "discount_rate")
    private BigDecimal discountRate;

    @Enumerated(EnumType.STRING)
    @Column(name = "discount_priority")
    private DiscountPriority discountPriorit = DiscountPriority.NONE;

    @Column(name = "view_count")
    private Integer viewCount;

    @Column(name= "like_count")
    private Integer likeCount;

    @Column(name="review_count")
    private Integer reviewCount;

    @Column(name = "rating_avg")
    private BigDecimal ratingAvg;

    @Column(name = "estimated_delivery_days")
    private Integer estimatedDeliveryDays = 3;

    @Enumerated(EnumType.STRING)
    @Column(name = "shoe_status",nullable = false)
    private ShoeStatus shoeStatus = ShoeStatus.DRAFT;

    @Enumerated(EnumType.STRING)
    @Column(name = "approval_status",nullable = false)
    private ApprovalStatus approvalStatus = ApprovalStatus.PENDING;

    @Column(name = "rejection_reason", length = 200)
    private String rejectionReason = "관리자에게 문의하시길 바랍니다.";

    @ManyToOne
    @JoinColumn(name = "user_id") // 승인하는 관리자 아이디에 해당되는 것
    private User ApprovedBy;

    @Column(name = "approved_at") // 승인날짜
    private LocalDateTime approvedAt;

    @Column(name = "is_active",nullable = false) // 활성화여부
    private Boolean isActive = true;

    @Column(name = "is_featured") // 추천상품,일반상품
    private Boolean isFeatured = false;

    @Column(name = "is_new_arrival")
    private Boolean isNewArrival=false;

    @Column(name = "display_start_date", nullable = false)
    private LocalDateTime displayStartDate;

    @Column(name = "display_end_date", nullable = false)
    private LocalDateTime displayEndDate;

    @Version // 낙관적 락, 동시성 문제 방지용(동시 수정 시에 충돌 방지용)
    @Column(name = "version")
    private Integer version;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;


    // 전시기간 디폴트값 생성(기본 현재시간~30일)
    @PrePersist
    protected void onCreate() {
        if (displayStartDate == null) {
            displayStartDate = LocalDateTime.now();
        }

        if (displayEndDate == null) {
            displayEndDate = displayStartDate.plusDays(30);
        }

        // 검증 로직
        validateDisplayDates();
    }


    //DB(제약조건)와 app단(validateDisplayDates) 이중 검증
    private void validateDisplayDates() {
        LocalDateTime now = LocalDateTime.now();

        if (displayStartDate.isBefore(now)) {
            throw new IllegalArgumentException("시작일은 현재 시간 이후여야 합니다.");
        }

        if (displayEndDate.isBefore(displayStartDate)) {
            throw new IllegalArgumentException("종료일은 시작일 이후여야 합니다.");
        }
    }

    @Builder
    public Shoe(String shoeName, LocalDateTime displayStartDate, LocalDateTime displayEndDate) {
        this.shoeName = shoeName;
        this.displayStartDate = displayStartDate;
        this.displayEndDate = displayEndDate;
    }

}
