package br.com.bev.repository;

import br.com.bev.model.Ingresso;
import br.com.bev.model.Turista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngressoRepository extends JpaRepository<Ingresso, Long> {

    List<Ingresso> findAllByTurista(Turista turista);

}
