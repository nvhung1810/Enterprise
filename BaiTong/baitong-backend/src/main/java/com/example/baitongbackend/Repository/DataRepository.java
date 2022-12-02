package com.example.baitongbackend.Repository;

import com.example.baitongbackend.Model.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataRepository extends JpaRepository<Data, Long> {
    List<Data> findByTenhangContaining(String tenhang);
}