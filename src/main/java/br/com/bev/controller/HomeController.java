package br.com.bev.controller;

import br.com.bev.config.security.annotations.AllowAdmin;
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
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String index() {
        return "redirect:/swagger-ui.html";
    }

}
