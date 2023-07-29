package com.kn.koshelap.transcoder.controller;

import static java.sql.Timestamp.valueOf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kn.koshelap.transcoder.dto.search.CapitalSearchDto;
import com.kn.koshelap.transcoder.repository.CapitalRepository;
import com.kn.koshelap.transcoder.service.CapitalService;

@RestController
@RequestMapping("/api")
public class CapitalController {

    @Autowired
    private CapitalService service;

    @Autowired
    CapitalRepository capitalRepository;

    @PostMapping("/capital/search")
    public ResponseEntity<?> find(@RequestBody CapitalSearchDto searchDto) {
        return new ResponseEntity<>(service.find(searchDto), HttpStatus.OK);
    }

    @GetMapping("/capital/all")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }



}
