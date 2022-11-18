package com.holeiko.lab5.repository;

import com.holeiko.lab5.domain.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ClientRepository extends JpaRepository<Clients, Integer> {

    @Override
    List<Clients> findAll();

    @Override
    Optional<Clients> findById(Integer integer);
    @Modifying
    @Query(value= "CALL AddClient( :nameIn , :surnameIn , :emailIn , :phoneIn );", nativeQuery = true)
    void AddClient(@Param("nameIn") String nameIn, @Param("surnameIn") String surnameIn, @Param("emailIn") String emailIn, @Param("phoneIn") String phoneIn);

    @Modifying
    @Query(value= "CALL holeiko_db.AddTenFakeClients()", nativeQuery = true)
    void AddTenFakeClients();


    @Query(value = "SELECT MaxWaterConsume()", nativeQuery = true)
    public Integer getMaxWaterConsume();
    @Modifying
    @Query(value = "CALL CreateTablesWithCursor", nativeQuery = true)
    public void createTables();


}
