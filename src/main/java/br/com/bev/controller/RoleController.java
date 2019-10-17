package br.com.bev.controller;

import br.com.bev.model.Role;
import br.com.bev.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/create")
    public ResponseEntity create(Role role){
        return ResponseEntity.ok(roleRepository.save(role));
    }
}
