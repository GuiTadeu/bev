package br.com.bev.controller;

import br.com.bev.model.Turista;
import br.com.bev.repository.TuristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turista")
public class TuristaController {

    @Autowired
    TuristaRepository turistaRepository;

    @PostMapping("/create")
    public ResponseEntity<Turista> create(@Valid @RequestBody Turista turista, UriComponentsBuilder uriBuilder){
        turistaRepository.save(turista);
        URI uri = uriBuilder.path("/turistas/{id}").buildAndExpand(turista.getId()).toUri();
        return ResponseEntity.created(uri).body(turista);
    }

    @GetMapping("/retrieve")
    public List<Turista> retrieve(){
        return turistaRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Turista> update(@Valid @RequestBody Turista turista, @PathVariable Long id){
        Optional<Turista> turistaOptional = turistaRepository.findById(id);
        if(turistaOptional.isPresent()){
            turista.setId(id);
            turistaRepository.save(turista);
            return ResponseEntity.ok(turista);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Turista> turistaOptional = turistaRepository.findById(id);
        if(turistaOptional.isPresent()){
            turistaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
