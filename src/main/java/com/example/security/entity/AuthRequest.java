package com.example.security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthRequest {

    private String userName;
    private String passWord;

}
