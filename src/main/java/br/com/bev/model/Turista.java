package br.com.bev.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Turista {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Nome é Obrigatório")
    private String nome;

    @NotNull(message = "Data de Nascimento é Obrigatória")
    private LocalDate nascimento;

    @CPF
    @NotBlank(message = "CPF é Obrigatório")
    private String cpf;

    @NotBlank(message = "Foto é Obrigatória")
    private String fotoPerfil;

    @ManyToMany
    @Null
    private List<Viagem> viagens;

}
