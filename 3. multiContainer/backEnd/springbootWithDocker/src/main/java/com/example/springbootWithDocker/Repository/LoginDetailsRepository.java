package com.example.springbootWithDocker.Repository;

import com.example.springbootWithDocker.model.LoginDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDetailsRepository extends JpaRepository<LoginDetailsModel, Integer> {

    LoginDetailsModel findByEmail(String email);
}
