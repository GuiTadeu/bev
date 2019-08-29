package br.com.bev.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@MappedSuperclass
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é Obrigatório")
    private String nome;

    @CPF
    @NotBlank(message = "CPF é Obrigatório")
    private String cpf;

    @Email
    @NotBlank(message = "Email é Obrigatório")
    private String email;

    @NotBlank(message = "Foto é Obrigatória")
    private String fotoPerfil;
}
