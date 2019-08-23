package br.com.bev.controller;

import br.com.bev.model.Viagem;
import br.com.bev.repository.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/viagem")
public class ViagemController {

    @Autowired
    private ViagemRepository viagemRepository;

    @PostMapping("/create")
    public ResponseEntity<Viagem> create(@Valid @RequestBody Viagem viagem, UriComponentsBuilder uriBuilder){
        viagemRepository.save(viagem);
        URI uri = uriBuilder.path("/viagem/{id}").buildAndExpand(viagem.getId()).toUri();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/retrieve")
    public List<Viagem> retrieve(){
        return viagemRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Viagem> update(@Valid @RequestBody Viagem viagem, @PathVariable Long id){
        Optional<Viagem> viagemOptional = viagemRepository.findById(id);
        if(viagemOptional.isPresent()){
            viagem.setId(id);
            viagemRepository.save(viagem);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Viagem> delete(@PathVariable Long id){
        Optional<Viagem> viagemOptional = viagemRepository.findById(id);
        if(viagemOptional.isPresent()){
            viagemRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
