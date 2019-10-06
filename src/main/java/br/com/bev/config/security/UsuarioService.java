package br.com.bev.config.security;

import br.com.bev.model.Usuario;
import br.com.bev.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public class UsuarioService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(username);


        if(usuario.isPresent()){
            Usuario user = usuario.get();
            return new User(user.getUsername(), user.getPassword(), true, true, true, true, user.getAuthorities());
        }

        throw new UsernameNotFoundException(
                "Não foi possível encontrar o usuario com email: " + username);
    }
}
