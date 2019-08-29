package br.com.bev.form;


import br.com.bev.model.Turista;
import br.com.bev.model.Viagem;
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
@AllArgsConstructor
public class TuristaForm {

    private String nome;
    private String email;
    private String cpf;
    private String fotoPerfil;


    public TuristaForm(Turista turista) {
        this.nome = turista.getNome();
        this.email = turista.getEmail();
        this.cpf = turista.getCpf();
        this.fotoPerfil = turista.getFotoPerfil();
    }

    public Turista toTurista() {
        return new Turista(nome, email, cpf, fotoPerfil);
    }
}
