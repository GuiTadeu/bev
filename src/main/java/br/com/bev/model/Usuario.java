package br.com.bev.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@MappedSuperclass
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_GEN_ID")
    @SequenceGenerator(name = "USUARIO_GEN_ID", sequenceName = "USUARIO_ID_SEQ")
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
