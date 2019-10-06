package br.com.bev.controller;

import br.com.bev.model.Organizador;
import br.com.bev.model.Turista;
import br.com.bev.model.Usuario;
import br.com.bev.model.Viagem;
import br.com.bev.repository.OrganizadorRepository;
import br.com.bev.repository.TuristaRepository;
import br.com.bev.repository.UsuarioRepository;
import br.com.bev.repository.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

@ApiIgnore
@Controller
@RequestMapping("/populate")
public class PopulateDatabaseController {

    @Autowired
    OrganizadorRepository organizadorRepository;

    @Autowired
    TuristaRepository turistaRepository;

    @Autowired
    ViagemRepository viagemRepository;

    @GetMapping
    public String populate(){
        Organizador organizador = new Organizador("Graça", "46598997054", "graca@gmail.com", "$2a$10$ZZ09PypLo3AUWHr6iH8OuOJSP921c5HTUDv4vbT2PbePsKlDM2lQ2", "HTPP");
        Turista turista = new Turista("Guilherme", "guilherme@gmail.com", "$2a$10$ZZ09PypLo3AUWHr6iH8OuOJSP921c5HTUDv4vbT2PbePsKlDM2lQ2", "23384647025", "HTTP");
        Turista turista2 = new Turista("Gabi", "gabi@gmail.com", "$2a$10$ZZ09PypLo3AUWHr6iH8OuOJSP921c5HTUDv4vbT2PbePsKlDM2lQ2", "89393384053", "HTTP");
        Turista turista3 = new Turista("Guto", "guto@gmail.com", "$2a$10$ZZ09PypLo3AUWHr6iH8OuOJSP921c5HTUDv4vbT2PbePsKlDM2lQ2", "06885390097", "HTTP");

        ArrayList<String> embarque = new ArrayList<>();
        embarque.add("rua 1");
        embarque.add("rua 2");

        organizadorRepository.save(organizador);

        Viagem viagem = new Viagem("Campos do Jordão", organizador, "TOP DEMAIS", "HTTP", new BigDecimal(200), 20, embarque, LocalDate.now(), LocalDate.now());
        Viagem viagem2 = new Viagem("Paraty", organizador, "MUITO LINDO", "HTTP", new BigDecimal(200), 20, embarque, LocalDate.now(), LocalDate.now());


        turistaRepository.save(turista);
        turistaRepository.save(turista2);
        turistaRepository.save(turista3);

        viagemRepository.save(viagem);
        viagemRepository.save(viagem2);

        return "redirect:/h2-console";
    }
}
