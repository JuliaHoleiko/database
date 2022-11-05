package com.holeiko.lab5.repository;

import com.holeiko.lab5.domain.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Clients, Integer> {

    @Override
    List<Clients> findAll();

    @Override
    Optional<Clients> findById(Integer integer);



   }
