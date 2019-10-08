package br.com.bev.controller;

import br.com.bev.form.OrganizadorCadastroForm;
import br.com.bev.form.OrganizadorForm;
import br.com.bev.form.ViagemForm;
import br.com.bev.model.Organizador;
import br.com.bev.model.Viagem;
import br.com.bev.repository.OrganizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/organizador")
public class OrganizadorController {
    @Autowired
    OrganizadorRepository organizadorRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<OrganizadorForm> create(@Valid @RequestBody OrganizadorCadastroForm form, UriComponentsBuilder uriBuilder){
        Organizador organizador = form.toOrganizador();
        organizadorRepository.save(organizador);
        URI uri = uriBuilder.path("/organizador/{id}").buildAndExpand(organizador.getId()).toUri();
        return ResponseEntity.created(uri).body(new OrganizadorForm(organizador));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizadorForm> findById(@PathVariable Long id) {
        Optional<Organizador> turistaOptional = organizadorRepository.findById(id);
        if (turistaOptional.isPresent()) {
            return ResponseEntity.ok(new OrganizadorForm(turistaOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}/viagens")
    public ResponseEntity<List<ViagemForm>> listaDeViagens(@PathVariable Long id){
        Optional<Organizador> organizadorOptional = organizadorRepository.findById(id);
        if (organizadorOptional.isPresent()) {
            return ResponseEntity.ok(
                    organizadorOptional.get().getViagens().stream()
                    .map(ViagemForm::new)
                    .collect(Collectors.toList())
            );
        }
        return ResponseEntity.notFound().build();
    }
}
