package br.com.bev.form;

import br.com.bev.model.Role;
import br.com.bev.model.Turista;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
public class TuristaCadastroForm {

    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String fotoPerfil;

    public TuristaCadastroForm(Turista turista){
        this.nome = turista.getNome();
        this.email = turista.getEmail();
        this.senha = turista.getSenha();
        this.cpf = turista.getCpf();
        this.fotoPerfil = turista.getFotoPerfil();
    }

    public Turista toTurista(){
        List<Role> authorities = new ArrayList<>();
        authorities.add(Role.ROLE_TURISTA);
        return new Turista(nome, email, senha, cpf, fotoPerfil, authorities);
    }
}
