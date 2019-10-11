package br.com.bev.controller.tests;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turista-auth")
public class TestTuristaController {

    @GetMapping
    @Secured("ROLE_TURISTA")
    public ResponseEntity turista(){
        return ResponseEntity.ok().build();
    }
}