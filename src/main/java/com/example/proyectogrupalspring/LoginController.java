package com.example.proyectogrupalspring;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private SecurityService security;
    @GetMapping("/login/{token}")
    public ResponseEntity login(HttpServletRequest request, @PathVariable String token){
        HttpSession s = request.getSession();
        if(security.validateToken(token) ) {
            s.setAttribute("login", true);
            return new ResponseEntity<>("Successfully logged!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity logout(HttpServletRequest request){
        HttpSession s = request.getSession();
        s.setAttribute("login",false);
        return new ResponseEntity<String>("Successfully logged out!",HttpStatus.OK);
    }
}
