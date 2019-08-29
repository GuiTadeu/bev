package br.com.bev.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Organizador extends Usuario{

    @OneToMany(mappedBy = "organizador", cascade=CascadeType.ALL)
    private List<Viagem> viagens;

    public Organizador(String nome, String cpf, String email, String fotoPerfil) {
        setNome(nome);
        setCpf(cpf);
        setEmail(email);
        setFotoPerfil(fotoPerfil);
    }
}
