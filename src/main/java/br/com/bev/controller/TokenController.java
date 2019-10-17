package br.com.bev.controller;

import br.com.bev.config.security.TokenManager;
import br.com.bev.form.UsuarioForm;
import br.com.bev.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    TokenManager tokenManager;

    @GetMapping("/getUser")
    public ResponseEntity<UsuarioForm> getUser(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        return ResponseEntity.ok(new UsuarioForm(usuario));
    }
}
