package br.com.bev.controller;

import br.com.bev.model.Embarque;
import br.com.bev.model.Turista;
import br.com.bev.model.Viagem;
import br.com.bev.repository.EmbarqueRepository;
import br.com.bev.repository.TuristaRepository;
import br.com.bev.repository.ViagemRepository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/embarque")
public class EmbarqueController {

    @Autowired
    EmbarqueRepository embarqueRepository;

    @Autowired
    TuristaRepository turistaRepository;

    @Autowired
    ViagemRepository viagemRepository;

    @PostMapping("viagem/{idViagem}/turista/{idTurista}")
    public ResponseEntity<Embarque> embarcarTurista(@PathVariable Long idViagem, @PathVariable Long idTurista){
        Optional<Viagem> viagemOptional = viagemRepository.findById(idViagem);
        Optional<Turista> turistaOptional = turistaRepository.findById(idTurista);
        if(viagemOptional.isPresent() && turistaOptional.isPresent()){
            Embarque embarque = new Embarque(turistaOptional.get().getId(), viagemOptional.get().getId());
            embarqueRepository.save(embarque);
            return ResponseEntity.ok(embarque);
        }
        return ResponseEntity.notFound().build();
    }
}
