package br.com.bev.controller;

import br.com.bev.config.security.TokenManager;
import br.com.bev.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenManager tokenManager;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticationTokenOutputDTO> authenticate(@RequestBody LoginInputDTO login){

        UsernamePasswordAuthenticationToken authenticationToken = login.build();

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        String jwt = tokenManager.generateToken(authentication);
        AuthenticationTokenOutputDTO tokenResponse = new AuthenticationTokenOutputDTO("Bearer", jwt);

        return ResponseEntity.ok(tokenResponse);
    }
}
