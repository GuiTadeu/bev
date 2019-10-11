package br.com.bev.controller.tests;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organizador-auth")
public class TestOrganizadorController {

    @GetMapping
    @Secured("ROLE_ORGANIZADOR")
    public ResponseEntity organizador(){
        return ResponseEntity.ok().build();
    }
}