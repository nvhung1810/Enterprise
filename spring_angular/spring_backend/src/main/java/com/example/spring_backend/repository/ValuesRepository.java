package com.example.spring_backend.repository;

import com.example.spring_backend.model.Values;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ValuesRepository extends JpaRepository<Values, Long> {
//    List<Values> findByPublished(boolean published);

//    Phải là fintitleContaining thì mới tìm kiếm bên fontend  được
    List<Values> findByTenhang_hungContaining(String tenhang_hung);
}