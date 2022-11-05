package com.holeiko.lab5.repository;

import com.holeiko.lab5.domain.Areas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Areas, Integer> {
    @Override
    List<Areas> findAll();

    List<Areas> findBySquare (Integer square);

    @Override
    void deleteById(Integer integer);
}
