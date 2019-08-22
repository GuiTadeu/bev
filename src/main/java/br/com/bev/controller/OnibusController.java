package br.com.bev.controller;

import br.com.bev.model.Onibus;
import br.com.bev.repository.OnibusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/onibus")
public class OnibusController {

    @Autowired
    OnibusRepository onibusRepository;

    @GetMapping("/form")
    public String form(){
        return "onibus/form";
    }

    @PostMapping("/create")
    public String create(Onibus onibus){
        onibusRepository.save(onibus);
        return "onibus/listar";
    }
}
