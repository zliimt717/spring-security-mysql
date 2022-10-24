package com.example.security.controller;

import com.example.security.entity.AuthRequest;
import com.example.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

  @GetMapping(path = "/")
  public String welCome(){
      return "Welcome to SpringSecurityApplication";
  }

  @PostMapping(path = "/authenticate")
  public String generateToken(@RequestBody AuthRequest authRequest)throws Exception{
      try{
          authenticationManager.authenticate(
                  new UsernamePasswordAuthenticationToken(
                          authRequest.getUserName(),authRequest.getPassWord())
          );

      }catch (Exception e){
          throw new Exception("invalid username/password");
      }
      return jwtUtil.generateToken(authRequest.getUserName());
  }
}
