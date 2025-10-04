package com.github.chore.repository.entity.option_shoe_list;

import com.github.chore.repository.entity.order_list.OrderList;
import com.github.chore.repository.entity.order_list.OrderStatus;
import com.github.chore.repository.entity.shoe_option.ShoeOption;
import jakarta.persistence.*;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "order_shoe_list")
@Entity
public class OptionShoeList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_shoe_list_id", nullable = false)
    private Integer order_shoe_list_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shoe_option_id", nullable = false)
    private ShoeOption shoeOption;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_list_id", nullable = false)
    private OrderList orderListId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity=1;

    @Column(name = "unit_price",nullable = false)
    private BigDecimal unitPrice;

    @Builder.Default
    @Column(name = "option_additional_price")
    private BigDecimal optionAdditionalPrice = BigDecimal.valueOf(0);

    @Builder.Default
    @Column(name = "discount_amount")
    private BigDecimal discountAmount = BigDecimal.valueOf(0);

    @Column(name = "final_unit_price")
    private BigDecimal finalUnitPrice;


    @Column(name = "total_amount")
    private BigDecimal totalAmount;


    @Builder.Default
    @Column(name = "is_cancellable")
    private Boolean isCancellable = true;


    @Builder.Default
    @Column(name = "order_shoe_status",nullable = false)
    private OrderShoeStatus orderShoeStatus=OrderShoeStatus.ORDERED ;


    @Column(name = "snapshot_shoe_name",nullable = false)
    private String snapshotShoeName;


    @Column(name = "snapshot_brand",nullable = false, length = 50)
    private String snapshotBrand;


    @Column(name = "snapshot_color",nullable = false, length = 50)
    private String snapshotColor;


    @Column(name = "snapshot_size",nullable = false)
    private Integer snapshoeSize;


    @Column(name = "created_at", nullable = false, updatable = false) // 자동 입력 기능 필요 : @LastModifiedDate와 Auditing 설정
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updatedAt;

}
