package com.github.chore.repository.entity.shippong_policy;
import com.github.chore.repository.entity.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "shipping_policy")
public class ShippingPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_policy_id", nullable = false)
    private Integer shippingPolicyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    @Column(name = "policy_name", nullable = false, length = 100)
    private String policyName;

    @Enumerated(EnumType.STRING)
    @Column(name = "policy_type", nullable = false)
    private PolicyType policyType;

    @Column(name = "base_fee", nullable = false)
    private BigDecimal baseFee = BigDecimal.valueOf(0.00);

    @Column(name = "free_shipping_threshold")
    private BigDecimal freeShippingThreshold;

    @Column(name = "is_bundle_shipping")
    private Boolean isBundleShipping = false;

    @Column(name = "bundle_additional_fee")
    private BigDecimal bundleAdditionalFee;

    @Column(name = "is_active")
    private Boolean active = true;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "valid_from", nullable = false)
    private LocalDate validFrom;

    @Column(name = "valid_until")
    private LocalDate validUntil;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
