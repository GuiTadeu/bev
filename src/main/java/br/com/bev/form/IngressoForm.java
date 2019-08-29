package br.com.bev.form;

import br.com.bev.model.Ingresso;
import lombok.AllArgsConstructor;
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
public class IngressoForm {

    private String nomeViagem;
    private String nomeOrganizador;
    private String fotoViagem;
    private LocalDate dataViagem;
    private String qrCode;

    public IngressoForm(Ingresso ingresso) {
        this.nomeViagem = ingresso.getViagem().getNome();
        this.nomeOrganizador = ingresso.getOrganizador().getNome();
        this.fotoViagem = ingresso.getFotoViagem();
        this.dataViagem = ingresso.getDataViagem();
        this.qrCode = ingresso.getQrCode();
    }
}
