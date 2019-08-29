package br.com.bev.controller;

import br.com.bev.model.Organizador;
import br.com.bev.model.Turista;
import br.com.bev.model.Viagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller criado para redirecionar a
 * requisição ao root para o Swagger-UI.
 * @author Guilherme Tadeu
 * @version 1.0.0
 */

@Controller
@ApiIgnore
public class HomeController {

    @Autowired

    @RequestMapping("/")
    public String index() {
        return "redirect:/swagger-ui.html";
    }

}
