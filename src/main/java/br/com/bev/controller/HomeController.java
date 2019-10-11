package br.com.bev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Controller criado para redirecionar a
 * requisição ao root para o Swagger-UI.
 * @author Guilherme Tadeu
 * @version 1.0.0
 */

@ApiIgnore
@Controller
@RequestMapping("/swagger")
public class HomeController {

    @GetMapping
    public String index() {
        return "redirect:/swagger-ui.html";
    }

}
