package com.github.chore.repository.entity.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email); // null 체크, optional이 아니면 서비스단에서 orElseThrow 사용 못함
}


