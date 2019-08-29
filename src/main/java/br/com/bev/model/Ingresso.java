package br.com.bev.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeViagem;
    private String nomeOrganizador;
    private String fotoViagem;
    private LocalDateTime dataViagem;
    private String qrCode;

    public Ingresso(String nomeViagem, String nomeOrganizador, String fotoViagem, LocalDateTime dataViagem, String qrCode) {
        this.nomeViagem = nomeViagem;
        this.nomeOrganizador = nomeOrganizador;
        this.fotoViagem = fotoViagem;
        this.dataViagem = dataViagem;
        this.qrCode = qrCode;
    }
}
