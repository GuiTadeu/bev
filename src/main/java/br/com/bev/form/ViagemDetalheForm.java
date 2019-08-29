package br.com.bev.form;

import br.com.bev.model.Viagem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ViagemDetalheForm {

    private Long id;
    private String nome;
    private String nomeOrganizador;
    private String descricao;
    private String fotoDestaque;
    private BigDecimal preco;
    private Integer qtdVagas;
    private List<String> pontosEmbarques;
    private LocalDate dataSaida;
    private LocalDate dataChegada;

    public ViagemDetalheForm(Viagem viagem){
        this.id = viagem.getId();
        this.nome = viagem.getNome();
        this.nomeOrganizador = viagem.getOrganizador().getNome();
        this.descricao = viagem.getDescricao();
        this.fotoDestaque = viagem.getFotoDestaque();
        this.preco = viagem.getPreco();
        this.qtdVagas = viagem.getQtdVagas();
        this.pontosEmbarques = viagem.getPontosEmbarques();
        this.dataSaida = viagem.getDataSaida();
        this.dataChegada = viagem.getDataChegada();
    }

}
