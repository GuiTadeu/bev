package br.com.bev.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Organizador {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Nome é Obrigatório")
    private String nome;

    @CPF
    @NotBlank(message = "CPF é Obrigatório")
    private String cpf;

    @Email
    @NotBlank(message = "Email é Obrigatório")
    private String email;

    @ManyToMany
    private List<Viagem> viagens;

}
