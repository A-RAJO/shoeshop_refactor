package com.github.chore.repository.entity.inventory;

import com.github.chore.repository.entity.shoe_option.ShoeOption;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id", nullable = false)
    private Integer inventoryId;

    @OneToOne
    @JoinColumn(name = "shoe_option_id", nullable = false)
    private ShoeOption shoeOption;

    @Column(name = "initial_stock", nullable = false)
    private Integer initialStock;

    @Column(name = "current_stock", nullable = false)
    private Integer currnentStock;

    @Column(name = "sold_quantity", nullable = false)
    private Integer soldQuantity;

    @Column(name = "reserved_quantity", nullable = false)
    private Integer reservedQuantity;

    @Column(name = "damaged_quantity", nullable = false)
    private Integer damagedQuantity;

    @Column(name = "returned_quantity", nullable = false)
    private Integer returnedQuantity;

    @Column(name = "available_stock")
    private Integer availableStock;

    @Column(name = "is_sordout")
    private Boolean isSordout;

    @Column(name = "min_stock_alert")
    private Integer minStockAlert;

    @Column(name = "is_low_stock")
    private Boolean isLowStock;

    @Column(name = "last_restocked_at")
    private LocalDateTime lastRestockedAt;

    @Column(name = "last_sold_at")
    private LocalDateTime lastSoldAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "redis_sync_status")
    private RedisSyncStatus redisSyncStatus;

    @Column(name = "last_redis_sync_at")
    private LocalDateTime lastRedisSyncAt;

    @Column(name = "redis_version")
    private Integer redisVersion;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updatedAt;
}
