package br.com.bev.form;

import br.com.bev.model.Viagem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
public class ViagemDetalheForm {

    private String nome;
    private String nomeOrganizador;
    private String descricao;
    private String fotoDestaque;
    private BigDecimal preco;
    private Integer qtdVagas;
    private ArrayList<String> pontosEmbarques;
    private LocalDateTime dataHoraSaida;
    private LocalDateTime dataHoraChegada;

    public ViagemDetalheForm(Viagem viagem){
        this.nome = viagem.getNome();
        this.nomeOrganizador = viagem.getOrganizador().getNome();
        this.descricao = viagem.getDescricao();
        this.fotoDestaque = viagem.getFotoDestaque();
        this.preco = viagem.getPreco();
        this.qtdVagas = viagem.getQtdVagas();
        this.pontosEmbarques = viagem.getPontosEmbarques();
        this.dataHoraSaida = viagem.getDataHoraSaida();
        this.dataHoraChegada = viagem.getDataHoraChegada();
    }

}
