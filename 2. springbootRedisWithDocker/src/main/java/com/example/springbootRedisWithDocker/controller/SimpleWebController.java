package com.example.springbootRedisWithDocker.controller;

import com.example.springbootRedisWithDocker.service.PageVisitCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleWebController {
    @Autowired
    private PageVisitCountService pageVisitCountService;

    @GetMapping("/")
    public ResponseEntity<String> addToCache() {
        return pageVisitCountService.pageVisitCount();
    }

}
