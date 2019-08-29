package br.com.bev.model;

import br.com.bev.repository.TuristaRepository;
import br.com.bev.repository.ViagemRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Tabela associativa de Turista e Viagem
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Embarque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long turista;
    private Long viagem;


    public Embarque(Long turista, Long viagem) {
        this.turista = turista;
        this.viagem = viagem;
    }

    public Ingresso gerarIngresso(TuristaRepository turistaRepository, ViagemRepository viagemRepository) {
        Turista turista = turistaRepository.findById(this.turista).get();
        Viagem viagem = viagemRepository.findById(this.viagem).get();

        return new Ingresso(
                viagem.getNome(),
                viagem.getOrganizador().getNome(),
                viagem.getFotoDestaque(),
                viagem.getDataHoraSaida(),
                generateQrCode());
    }

    /**
     * Gerando o QR Code com o Id da Viagem, Ingresso e Turista.
     * O código será utilizado no momento do embarque.
     */
    private String generateQrCode() {
        return String.valueOf(this.getTurista() + this.getId() + this.getViagem());
    }

}
