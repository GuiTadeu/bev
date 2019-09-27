package br.com.bev.repository;

import br.com.bev.model.Usuario;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UsuarioRepository extends Repository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
