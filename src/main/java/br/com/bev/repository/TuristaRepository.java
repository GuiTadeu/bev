package br.com.bev.repository;

import br.com.bev.model.Turista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuristaRepository extends JpaRepository<Turista, Long> {
}
