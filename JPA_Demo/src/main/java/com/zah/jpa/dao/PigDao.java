package com.zah.jpa.dao;

import com.zah.jpa.entity.Pig;
import com.zah.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PigDao extends JpaRepository<Pig, Integer> {

    @Query("select p from Pig p where p.owner = :owner")
    List<Pig> getOwnPig(@Param("owner") String owner);

    Pig save(Pig pig);
}