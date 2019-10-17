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
public class Turista extends Usuario {

    @ManyToMany(mappedBy = "turistas", cascade = CascadeType.ALL)
    private List<Viagem> viagens;

    public Turista(String nome, String email, String senha, String cpf, String fotoPerfil, Role role) {
        setNome(nome);
        setEmail(email);
        setCpf(cpf);
        setSenha(senha);
        setFotoPerfil(fotoPerfil);
        setRole(role);
    }
}