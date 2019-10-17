package br.com.bev.controller.test;

import br.com.bev.config.security.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping("/test")
public class AuthorizationTests {

    @AllowAdmin
    @GetMapping("/admin")
    public ResponseEntity admin(){
        return ResponseEntity.ok("VOCÊ É ADMIN");
    }

    @AllowOrganizador
    @GetMapping("/organizador")
    public ResponseEntity organizador(){
        return ResponseEntity.ok("VOCÊ É ORGANIZADOR");
    }

    @AllowTurista
    @GetMapping("/turista")
    public ResponseEntity turista(){
        return ResponseEntity.ok("VOCÊ É TURISTA");
    }


}
