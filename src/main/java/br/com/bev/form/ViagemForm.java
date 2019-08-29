package br.com.bev.form;

import br.com.bev.model.Viagem;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/***
 * Classe auxiliar na criação do JSON omitindo
 * determindados atributos que não são
 * necessários serem exibidos
 */

@Getter
@Setter
public class ViagemForm {

    private Long id;
    private String nome;
    private String descricao;
    private String fotoDestaque;
    private BigDecimal preco;
    private Integer qtdVagas;

    public ViagemForm(Viagem viagem) {
        this.id = viagem.getId();
        this.nome = viagem.getNome();
        this.descricao = viagem.getDescricao();
        this.fotoDestaque = viagem.getFotoDestaque();
        this.preco = viagem.getPreco();
        this.qtdVagas = viagem.getQtdVagas();
    }

    public Viagem toViagem(){
        return new Viagem(nome, descricao, fotoDestaque, preco, qtdVagas);
    }
}
