package br.com.bev.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("ORGANIZADOR")
public class Organizador extends Usuario {

    @OneToMany(mappedBy = "organizador", cascade = CascadeType.ALL)
    private List<Viagem> viagens;

    public Organizador(String nome, String cpf, String email, String senha, String fotoPerfil) {
        setNome(nome);
        setCpf(cpf);
        setEmail(email);
        setSenha(senha);
        setFotoPerfil(fotoPerfil);
    }

    public Organizador(String nome, String cpf, String email, String fotoPerfil) {
        setNome(nome);
        setCpf(cpf);
        setEmail(email);
        setFotoPerfil(fotoPerfil);
    }
}
