package br.com.bev.controller;

import br.com.bev.model.Organizador;
import br.com.bev.model.Turista;
import br.com.bev.model.Viagem;
import br.com.bev.repository.OrganizadorRepository;
import br.com.bev.repository.TuristaRepository;
import br.com.bev.repository.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        Organizador organizador = new Organizador("Jubileu", "697.862.540-07", "jubileu@gmail.com", "HTPP");
        Turista turista = new Turista("Guilherme", "guilherme@gmail.com", "89480007053", "HTTP");
        Turista turista2 = new Turista("Jubileu", "jubi@gmail.com", "89393384053", "HTTP");
        Turista turista3 = new Turista("Pitagoras", "pitagoras@gmail.com", "06885390097", "HTTP");

        ArrayList<String> embarque = new ArrayList<>();
        embarque.add("rua 1");
        embarque.add("rua 2");

        ArrayList<Turista> turistas = new ArrayList<>();
        turistas.add(turista);
        turistas.add(turista2);
        turistas.add(turista3);


        Viagem viagem = new Viagem("Campos do Jordão", organizador, "TOP DEMAIS", "HTTP", new BigDecimal(200), 20, embarque, LocalDateTime.now(), LocalDateTime.now());
        Viagem viagem2 = new Viagem("Paraty", organizador, "MUITO LINDO", "HTTP", new BigDecimal(200), 20, embarque, LocalDateTime.now(), LocalDateTime.now());

        organizadorRepository.save(organizador);
        turistaRepository.save(turista);
        viagemRepository.save(viagem);
        viagemRepository.save(viagem2);

        return "redirect:/";
    }
}
