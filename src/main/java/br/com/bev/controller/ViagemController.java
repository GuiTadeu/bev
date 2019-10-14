package br.com.bev.controller;

import br.com.bev.config.security.annotations.AllowOrganizador;
import br.com.bev.form.TuristaForm;
import br.com.bev.form.ViagemCadastroForm;
import br.com.bev.form.ViagemDetalheForm;
import br.com.bev.form.ViagemForm;
import br.com.bev.model.Viagem;
import br.com.bev.repository.OrganizadorRepository;
import br.com.bev.repository.ViagemRepository;
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
@RequestMapping("/viagem")
public class ViagemController {

    @Autowired
    private ViagemRepository viagemRepository;

    @Autowired
    private OrganizadorRepository organizadorRepository;


    @AllowOrganizador
    @PostMapping("/create")
    public ResponseEntity<ViagemDetalheForm> create(@Valid @RequestBody ViagemCadastroForm form, UriComponentsBuilder uriBuilder) {
        Viagem viagem = form.toViagem(organizadorRepository);
        viagemRepository.save(viagem);
        URI uri = uriBuilder.path("/viagem/{id}").buildAndExpand(viagem.getId()).toUri();
        return ResponseEntity.created(uri).body(new ViagemDetalheForm(viagem));
    }

    @GetMapping("/retrieve")
    public List<ViagemForm> retrieve() {
        return viagemRepository.findAll().stream()
                .map(ViagemForm::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViagemDetalheForm> findById(@PathVariable Long id) {
        Optional<Viagem> viagemOptional = viagemRepository.findById(id);
        if (viagemOptional.isPresent()) {
            return ResponseEntity.ok(new ViagemDetalheForm(viagemOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @AllowOrganizador
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Viagem> delete(@PathVariable Long id) {
        Optional<Viagem> viagemOptional = viagemRepository.findById(id);
        if (viagemOptional.isPresent()) {
            viagemRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @AllowOrganizador
    @GetMapping("{idViagem}/turistas")
    public ResponseEntity<List<TuristaForm>> listaDeTuristasNaViagem(@PathVariable Long idViagem) {
        Optional<Viagem> viagemOptional = viagemRepository.findById(idViagem);
        if (viagemOptional.isPresent()) {
            return ResponseEntity.ok(viagemOptional.get().getTuristas()
                    .stream()
                    .map(TuristaForm::new)
                    .collect(Collectors.toList()));
        }
        return ResponseEntity.notFound().build();
    }
}
