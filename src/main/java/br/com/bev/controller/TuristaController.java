package br.com.bev.controller;

import br.com.bev.form.TuristaForm;
import br.com.bev.model.Turista;
import br.com.bev.model.Viagem;
import br.com.bev.repository.TuristaRepository;
import br.com.bev.repository.ViagemRepository;
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
    public ResponseEntity<Turista> create(@Valid @RequestBody TuristaForm form, UriComponentsBuilder uriBuilder){
        Turista turista = form.toTurista();
        turistaRepository.save(turista);
        URI uri = uriBuilder.path("/turistas/{id}").buildAndExpand(turista.getId()).toUri();
        return ResponseEntity.created(uri).body(turista);
    }

}
