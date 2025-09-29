package com.github.chore.repository.entity.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
//    Optional<Category> findByCategoryTypeAndCategoryGender(String categoryType, String categoryGender);
}
