package com.example.springbootWithDocker.service;

import com.example.springbootWithDocker.Repository.LoginDetailsRepository;
import com.example.springbootWithDocker.dto.LoginRequestDto;
import com.example.springbootWithDocker.dto.LoginResponseDto;
import com.example.springbootWithDocker.model.LoginDetailsModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Log4j2
public class UserDetailsService {

    private static final String HASH_KEY_NAME = "PAGE-HIT-COUNT";

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private LoginDetailsRepository loginDetailsRepository;

    public ResponseEntity<?> login(LoginRequestDto loginRequestDto){

        log.info("Login request : "+loginRequestDto);

        LoginResponseDto loginResponseDto = new LoginResponseDto();
        LoginDetailsModel loginDetailsModel = loginDetailsRepository.findByEmail(loginRequestDto.getEmail());

        if(loginDetailsModel == null){
            loginDetailsModel = new LoginDetailsModel();
            loginDetailsModel.setEmail(loginRequestDto.getEmail());
            loginDetailsModel.setPassword(loginRequestDto.getPassword());
            loginDetailsModel.setName(loginRequestDto.getName());
            loginDetailsRepository.save(loginDetailsModel);
            loginResponseDto.setResponse("Welcome "+ loginRequestDto.getName());
        }
        else
            loginResponseDto.setResponse("Hi "+ loginRequestDto.getName()+" your last login details : "+redisTemplate.opsForValue().get(loginDetailsModel.getEmail()));

        //Storing login timing in redis
        redisTemplate.opsForValue().set(loginDetailsModel.getEmail(),new Date());

        log.info("Login response : "+loginResponseDto);
        return ResponseEntity.ok().body(loginResponseDto);
    }
}
