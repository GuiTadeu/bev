package br.com.bev.form;

import br.com.bev.model.Role;
import br.com.bev.model.Turista;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/***
 * Classe auxiliar na criação do JSON omitindo
 * determindados atributos que não são
 * necessários serem exibidos
 */

@Getter
@Setter
@AllArgsConstructor
public class TuristaCadastroForm {

    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String fotoPerfil;

    public Turista toTurista(){
        return new Turista(nome, email, new BCryptPasswordEncoder().encode(senha), cpf, fotoPerfil, Role.ROLE_TURISTA);
    }
}
