package com.github.chore.repository.entity.shoe_detail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoeDetailRepository extends JpaRepository<ShoeDetail,Integer> {
}
