package br.com.bev.controller;

import br.com.bev.model.Organizador;
import br.com.bev.repository.OrganizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/organizador")
public class OrganizadorController {
    @Autowired
    OrganizadorRepository organizadorRepository;

    @PostMapping("/create")
    public ResponseEntity<Organizador> create(@Valid @RequestBody Organizador organizador, UriComponentsBuilder uriBuilder){
        organizadorRepository.save(organizador);
        URI uri = uriBuilder.path("/organizadors/{id}").buildAndExpand(organizador.getId()).toUri();
        return ResponseEntity.created(uri).body(organizador);
    }

    @GetMapping("/retrieve")
    public List<Organizador> retrieve(){
        return organizadorRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Organizador> update(@Valid @RequestBody Organizador organizador, @PathVariable Long id){
        Optional<Organizador> organizadorOptional = organizadorRepository.findById(id);
        if(organizadorOptional.isPresent()){
            organizador.setId(id);
            organizadorRepository.save(organizador);
            return ResponseEntity.ok(organizador);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Organizador> organizadorOptional = organizadorRepository.findById(id);
        if(organizadorOptional.isPresent()){
            organizadorRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
