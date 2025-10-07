package com.github.chore.repository.entity.order_shipping_detail;

import com.github.chore.repository.entity.shippong_policy.ShippingPolicy;
import com.github.chore.repository.entity.order_list.OrderList;
import com.github.chore.repository.entity.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "order_shipping_detail")
public class OrderShippingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_detail_id", nullable = false)
    private Integer shippingDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_list_id", nullable = false)
    private OrderList orderList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_policy_id", nullable = false)
    private ShippingPolicy shippingPolicy;

    @Column(name = "base_fee", nullable = false)
    private BigDecimal baseFee;

    @Column(name = "additional_fee")
    private BigDecimal additionalFee;

    @Column(name = "discount_amount")
    private BigDecimal discountAmount;

    @Column(name = "final_shipping_fee", nullable = false)
    private BigDecimal finalShippingFee;

    @Column(name = "logistics_company")
    private String logisticsCompany;

    @Column(name = "logistics_number")
    private String logisticsNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "shipping_status", nullable = false)
    private ShippingStatus shippingStatus = ShippingStatus.PENDING;

    @Column(name = "shipped_at")
    private LocalDateTime shippedAt;

    @Column(name = "delivered_at")
    private LocalDateTime deliveredAt;

    @Column(name = "recipient_name", nullable = false)
    private String recipientName;

    @Column(name = "recipient_phone", nullable = false)
    private String recipientPhone;

    @Column(name = "shipping_address", nullable = false, length = 300)
    private String shippingAddress;

    @Column(name = "delivery_memo", length = 200)
    private String deliveryMemo;

    @Column(name = "calculation_details", columnDefinition = "json")
    private String calculationDetails; // JSON 타입은 String으로 매핑, 필요 시 Json 처리

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


}
