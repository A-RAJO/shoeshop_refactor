package com.github.chore.repository.entity.shoe_option;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShoeOptionRepository extends JpaRepository<ShoeOption,Integer> {
}
