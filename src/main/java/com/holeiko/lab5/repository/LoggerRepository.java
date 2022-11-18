package com.holeiko.lab5.repository;

import com.holeiko.lab5.domain.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends JpaRepository<Logger, Integer> {
}
