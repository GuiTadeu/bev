package br.com.bev.form;

import br.com.bev.model.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioForm {

    private Long id;

    private String nome;

    private String email;

    private String fotoPerfil;

    private Role role;

    public UsuarioForm(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.fotoPerfil = usuario.getFotoPerfil();
        this.role = usuario.getRoles().get(0);
    }
}
