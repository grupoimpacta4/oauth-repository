package com.impacta.oauth.jwt.controller;
 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
  

import java.security.Principal;
 

@RestController
@RequestMapping("/users")
public class UserController {
	
	 
    @GetMapping("/me")
    public ResponseEntity<Principal> get(final Principal principal) {
        return ResponseEntity.ok(principal);
    }
    
    @GetMapping("/me/cpf")
    public String getMyCpf(final Principal principal) {
        return principal.getName();
    }
    

}
