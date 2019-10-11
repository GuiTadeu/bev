package br.com.bev.config.security;

import br.com.bev.model.Usuario;
import br.com.bev.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(username);

        return usuario.orElseThrow(() ->
                new UsernameNotFoundException("Não foi possível encontrar o Username"));
    }

    public UserDetails loadUserById(Long userId) {
        Optional<Usuario> usuario = usuarioRepository.findById(userId);

        return usuario.orElseThrow(() ->
                new UsernameNotFoundException("Não foi possível encontrar o ID"));
    }
}
