package br.com.bev.model;

import br.com.bev.repository.TuristaRepository;
import br.com.bev.repository.ViagemRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Turista turista;

    @OneToOne
    private Viagem viagem;

    @OneToOne
    private Organizador organizador;

    private String fotoViagem;
    private LocalDate dataViagem;
    private String qrCode;

    public Ingresso(Turista turista, Viagem viagem, Organizador organizador, String fotoViagem, LocalDate dataViagem) {
        this.turista = turista;
        this.viagem = viagem;
        this.organizador = organizador;
        this.fotoViagem = fotoViagem;
        this.dataViagem = dataViagem;
        this.qrCode = generateQrCode();
    }

    /**
     * Gerando o QR Code com o CPF
     * O código será utilizado no momento do embarque.
     */
    private String generateQrCode() {
        return String.valueOf(this.getTurista().getCpf() + this.getViagem().getId() + this.getOrganizador().getCpf()).toString();
    }
}
