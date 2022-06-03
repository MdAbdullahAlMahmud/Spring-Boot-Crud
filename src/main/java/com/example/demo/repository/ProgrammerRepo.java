package com.example.demo.repository;

import com.example.demo.model.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgrammerRepo extends JpaRepository<Programmer,Integer> {


    List<Programmer> findBypLanguage(String pLanguage);

    @Query("from Programmer where pName = ?1")
    List<Programmer> findByName(String pName);



}
