package com.github.chore.repository.entity.shoe_review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoeReviewRepository extends JpaRepository<ShoeReview,Integer> {
}
