package com.github.chore.repository.entity.option_shoe_list;

import com.github.chore.repository.entity.order_list.OrderList;
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
public class OrderShoeList {
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
    private Integer quantity;

    @Column(name = "unit_price",nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "option_additional_price")
    private BigDecimal optionAdditionalPrice;

    @Column(name = "discount_amount")
    private BigDecimal discountAmount;

    @Column(name = "final_unit_price")
    private BigDecimal finalUnitPrice;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    
    @Column(name = "is_cancellable")
    private Boolean isCancellable = true;

    
    @Column(name = "order_shoe_status",nullable = false)
    private OrderShoeStatus orderShoeStatus=OrderShoeStatus.ORDERED; // DB에도 설정되어 있지만 가독성 향상을 위해 디폴트값 명시

    @Column(name = "snapshot_shoe_name",nullable = false)
    private String snapshotShoeName;

    @Column(name = "snapshot_brand",nullable = false, length = 50)
    private String snapshotBrand;

    @Column(name = "snapshot_color",nullable = false, length = 50)
    private String snapshotColor;

    @Column(name = "snapshot_size",nullable = false)
    private Integer snapshoeSize;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updatedAt;

}
