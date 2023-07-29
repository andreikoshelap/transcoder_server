package com.kn.koshelap.transcoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kn.koshelap.transcoder.service.FilterConditionService;

@RestController
@RequestMapping("/api")
public class FilterConditionController {

    @Autowired
    private FilterConditionService service;


    @GetMapping("/filter/fields/all")
    public ResponseEntity<?> findFields() {
        return new ResponseEntity<>(service.getFieldNameList(), HttpStatus.OK);
    }

    @GetMapping("/filter/condition/all")
    public ResponseEntity<?> findCondition() {
        return new ResponseEntity<>(service.getConditionList(), HttpStatus.OK);
    }

    @GetMapping("/filter/all")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(service.getAllFilters(), HttpStatus.OK);
    }
}
