package com.kn.koshelap.transcoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kn.koshelap.transcoder.dto.FilterConditionDto;
import com.kn.koshelap.transcoder.dto.search.FilterSearchDto;
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

    @PostMapping("/filter/search")
    public ResponseEntity<?> find(@RequestBody FilterSearchDto searchDto) {
        return new ResponseEntity<>(service.find(searchDto), HttpStatus.OK);
    }

    @PostMapping("/filter/save")
    public ResponseEntity<?> save(@RequestBody FilterConditionDto filterDto) {
        return new ResponseEntity<>(service.save(filterDto), HttpStatus.OK);
    }

    @DeleteMapping("/filter/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
