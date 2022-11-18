package com.holeiko.lab5.repository;

import com.holeiko.lab5.domain.Workers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkersRepository extends JpaRepository<Workers, Integer> {
}
