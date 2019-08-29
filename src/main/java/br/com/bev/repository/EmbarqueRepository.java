package br.com.bev.repository;

import br.com.bev.model.Embarque;
import br.com.bev.model.Turista;
import br.com.bev.model.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmbarqueRepository extends JpaRepository<Embarque, Long> {
    List<Embarque> findEmbarquesByViagem(Long id);
    List<Embarque> findEmbarquesByTurista(Long id);
}
