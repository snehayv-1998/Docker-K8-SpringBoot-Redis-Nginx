package com.example.springbootRedisWithDocker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PageVisitCountService {

    private static final String HASH_KEY_NAME = "PAGE-HIT-COUNT";

    @Autowired
    private RedisTemplate redisTemplate;

    public ResponseEntity<String> pageVisitCount(){
        return ResponseEntity.ok("Number of time the website is visited is : " + redisTemplate.opsForHash().increment(HASH_KEY_NAME,1,1));
    }
}
