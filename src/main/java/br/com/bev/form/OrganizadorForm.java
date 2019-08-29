package br.com.bev.form;

import br.com.bev.model.Organizador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrganizadorForm {

    private String nome;
    private String cpf;
    private String email;
    private String fotoPerfil;

    public OrganizadorForm(Organizador organizador){
        this.nome = organizador.getNome();
        this.cpf = organizador.getCpf();
        this.email = organizador.getEmail();
        this.fotoPerfil = organizador.getFotoPerfil();
    }

    public Organizador toOrganizador(){
        return new Organizador(nome, cpf, email, fotoPerfil);
    }
}
