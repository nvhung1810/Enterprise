package com.example.spring_backend.repository;

import com.example.spring_backend.model.Values;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Values, Long> {
    List<Values> findByPublished(boolean published);

    List<Values> findByTitle(String title);

}