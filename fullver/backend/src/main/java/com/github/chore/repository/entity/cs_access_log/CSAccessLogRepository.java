package com.github.chore.repository.entity.cs_access_log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CSAccessLogRepository extends JpaRepository<CSAccessLog,Integer> {
}
