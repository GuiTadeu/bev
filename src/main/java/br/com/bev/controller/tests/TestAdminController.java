package br.com.bev.controller.tests;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin-auth")
public class TestAdminController {

    @GetMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity admin(){
        return ResponseEntity.ok().build();
    }
}