package com.example.baitongbackend.Controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.baitongbackend.Model.Data;
import com.example.baitongbackend.Repository.DataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
public class DataController {
    @Autowired
    DataRepository dataRepository;

    @GetMapping("/values")
//    Sửa string title theo giá tị cần tìm kiếm
    public ResponseEntity<List<Data>> getAllValues(     @RequestParam(required = false)
                                                        String keyword)
    {
        try {
            List<Data> values = new ArrayList<>();
            if (keyword == null)
                values.addAll(dataRepository.findAll());
            else
                values.addAll(dataRepository.search(keyword));

            if (values.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(values, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/values/{id}")
    public ResponseEntity<Data> getValueById(@PathVariable("id") long id) {
        Optional<Data> valueData = dataRepository.findById(id);
        if (valueData.isPresent()) {
            return new ResponseEntity<>(valueData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/values")
    public ResponseEntity<Data> createValue(@RequestBody Data value) {
        try {
//            sửa get theo table
            Data _value = dataRepository
                    .save(new Data(
                            value.getHoten(),
                            value.getTenbomon(),
                            value.getHesoluong()));
            return new ResponseEntity<>(_value, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/values/{id}")
    public ResponseEntity<Data> updateValue(@PathVariable("id") long id, @RequestBody Data value) {
        Optional<Data> valueData = dataRepository.findById(id);

        if (valueData.isPresent()) {
            Data _value = valueData.get();
//            sửa get det theo table
            _value.setHoten(value.getHoten());
            _value.setTenbomon(value.getTenbomon());
            _value.setHesoluong(value.getHesoluong());

//            ---------------------------------------
            return new ResponseEntity<>(dataRepository.save(_value), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/values/{id}")
    public ResponseEntity<HttpStatus> deleteValue(@PathVariable("id") long id) {
        try {
            dataRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/values")
    public ResponseEntity<HttpStatus> deleteAllValues() {
        try {
            dataRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}