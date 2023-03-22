package com.spring.web.controller.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
@RestController
@CrossOrigin("*")
@RequestMapping("/logout")
public class LogoutController {
    @Autowired
    private HttpSession session;

    @GetMapping("")
    public ResponseEntity<Void> logout() {
        session.invalidate();
        return ResponseEntity.ok().build();
    }
}
