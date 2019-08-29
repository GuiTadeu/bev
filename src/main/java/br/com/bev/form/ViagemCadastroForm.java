package br.com.bev.form;

import br.com.bev.model.Organizador;
import br.com.bev.model.Viagem;
import br.com.bev.repository.OrganizadorRepository;
import br.com.bev.repository.ViagemRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/***
 * Classe auxiliar na criação do JSON omitindo
 * determindados atributos que não são
 * necessários serem exibidos
 */

@Getter
@Setter
@AllArgsConstructor
public class ViagemCadastroForm {

    private String nome;
    private Long idOrganizador;
    private String descricao;
    private String fotoDestaque;
    private BigDecimal preco;
    private Integer qtdVagas;
    private ArrayList<String> pontosEmbarques;
    private LocalDate dataSaida;
    private LocalDate dataChegada;

    /**
     * Criado para evitar ter que passar um organizador cheio no
     * momento da criação da viagem. Basta passar o ID e o método
     * se encarrega de cadastrar os dados corretamente.
     * */
    public Viagem toViagem(OrganizadorRepository organizadorRepository){
        Organizador organizador = organizadorRepository.findById(idOrganizador).get();
        return new Viagem(nome, organizador, descricao, fotoDestaque, preco, qtdVagas, pontosEmbarques, dataSaida, dataChegada);
    }
}
