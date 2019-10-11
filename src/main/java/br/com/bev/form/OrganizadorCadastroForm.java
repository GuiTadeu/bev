package br.com.bev.form;

import br.com.bev.model.Organizador;
import br.com.bev.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/***
 * Classe auxiliar na criação do JSON omitindo
 * determindados atributos que não são
 * necessários serem exibidos
 */

@Getter
@Setter
@AllArgsConstructor
public class OrganizadorCadastroForm {

    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String fotoPerfil;

    public Organizador toOrganizador(){
        return new Organizador(nome, cpf, email, new BCryptPasswordEncoder().encode(senha), fotoPerfil);
    }
}
