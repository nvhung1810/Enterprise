package com.example.spring_backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.spring_backend.model.Values;
import com.example.spring_backend.repository.ValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    ValuesRepository valuesRepository;

    @GetMapping("/values")
//    Sửa string title theo giá tị cần tìm kiếm
    public ResponseEntity<List<Values>> getAllValues(@RequestParam(required = false) String name) {
        try {
            List<Values> values = new ArrayList<>();

            if (name == null)
                values.addAll(valuesRepository.findAll());
            else
//                sửa theo findby... ở bên repository
                values.addAll(valuesRepository.findByTenhangContaining(name));

            if (values.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(values, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/values/{id}")
    public ResponseEntity<Values> getValueById(@PathVariable("id") long id) {
        Optional<Values> valueData = valuesRepository.findById(id);
        if (valueData.isPresent()) {
            return new ResponseEntity<>(valueData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/values")
    public ResponseEntity<Values> createValue(@RequestBody Values value) {
        try {
//            sửa get theo table
            Values _value = valuesRepository
                    .save(new Values(
                            value.getTenhang(),
                            value.getGia_hung(),
                            value.getSoluong(),
                            value.getNgaynhap(),
                            value.getLoaihang()));
            return new ResponseEntity<>(_value, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/values/{id}")
    public ResponseEntity<Values> updateValue(@PathVariable("id") long id, @RequestBody Values value) {
        Optional<Values> valueData = valuesRepository.findById(id);

        if (valueData.isPresent()) {
            Values _value = valueData.get();
//            sửa get det theo table
            _value.setTenhang(value.getTenhang());
            _value.setGia_hung(value.getGia_hung());
            _value.setSoluong(value.getSoluong());
            _value.setNgaynhap(value.getNgaynhap());
            _value.setLoaihang(value.getLoaihang());

//            ---------------------------------------
            return new ResponseEntity<>(valuesRepository.save(_value), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/values/{id}")
    public ResponseEntity<HttpStatus> deleteValue(@PathVariable("id") long id) {
        try {
            valuesRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/values")
    public ResponseEntity<HttpStatus> deleteAllValues() {
        try {
            valuesRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    @GetMapping("/values/published")
//    public ResponseEntity<List<Values>> findByPublished() {
//        try {
//            List<Values> values = valuesRepository.findByPublished(true);
//
//            if (values.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(values, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}