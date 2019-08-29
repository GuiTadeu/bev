package br.com.bev.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Turista extends Usuario {

    @ManyToMany(mappedBy = "turistas")
    private List<Viagem> viagens;

    public Turista(String nome, String email, String cpf, String fotoPerfil) {
        setNome(nome);
        setEmail(email);
        setCpf(cpf);
        setFotoPerfil(fotoPerfil);
    }
}
