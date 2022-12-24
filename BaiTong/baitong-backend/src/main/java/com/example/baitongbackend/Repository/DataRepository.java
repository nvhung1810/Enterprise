package com.example.baitongbackend.Repository;

import com.example.baitongbackend.Model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataRepository extends JpaRepository<Data, Long> {
    @Query("SELECT u FROM Data u WHERE u.tenbomon LIKE %?1% AND cast(u.hesoluong as float ) <= ?1 ")
    public List<Data> search(String keyword);
}