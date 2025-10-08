package com.github.chore.repository.entity.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);

}
