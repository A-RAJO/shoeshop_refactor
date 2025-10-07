package com.github.chore.repository.entity.shippong_policy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingPolicyRepository extends JpaRepository<ShippingPolicy,Integer> {
}
