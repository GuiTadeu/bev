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
@DiscriminatorValue("TURISTA")
public class Turista extends Usuario {

    @ManyToMany(mappedBy = "turistas")
    private List<Viagem> viagens;

    public Turista(String nome, String email, String senha, String cpf, String fotoPerfil) {
        setNome(nome);
        setEmail(email);
        setCpf(cpf);
        setSenha(senha);
        setFotoPerfil(fotoPerfil);
    }

    public Turista(String nome, String email, String cpf, String fotoPerfil) {
        setNome(nome);
        setEmail(email);
        setCpf(cpf);
        setFotoPerfil(fotoPerfil);
    }
}
