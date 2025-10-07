package com.github.chore.repository.entity.order_shipping_detail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderShippingDetailRepository extends JpaRepository<OrderShippingDetail,Integer> {
}
