package br.com.bev.repository;

import br.com.bev.model.Turista;
import br.com.bev.model.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TuristaRepository extends JpaRepository<Turista, Long> {
}
