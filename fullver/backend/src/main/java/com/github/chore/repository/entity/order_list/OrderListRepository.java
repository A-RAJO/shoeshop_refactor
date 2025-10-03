package com.github.chore.repository.entity.order_list;

import com.github.chore.repository.entity.order_list.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderListRepository extends JpaRepository<OrderList,Integer> {
}
