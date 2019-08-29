package br.com.bev.model;

import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.MediaType;

import javax.persistence.*;
import javax.print.attribute.standard.Media;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é Obrigatório")
    private String nome;

    @NotBlank(message = "Descrição é Obrigatória")
    private String descricao;

    @NotBlank(message = "Insira a URL da Imagem")
    private String fotoDestaque;

    @NotNull(message = "Preço é Obrigatório")
    private BigDecimal preco;

    @NotNull(message = "Preço é Obrigatório")
    private Integer qtdVagas;

    @NotNull(message = "Data e Hora de Saída é Obrigatória")
    private LocalDateTime dataHoraSaida;

    @NotNull(message = "Data de Chegada é Obrigatória")
    private LocalDateTime dataHoraChegada;

    @NotNull(message = "Pontos de Embarque são Obrigatórios")
    private ArrayList<String> pontosEmbarques;

    @NotNull(message = "Organizador é Obrigatório")
    @ManyToOne
    private Organizador organizador;

    @ManyToMany
    @JoinTable(name = "EMBARQUE",
            joinColumns = {@JoinColumn(name = "VIAGEM")},
            inverseJoinColumns = {@JoinColumn(name = "TURISTA")})
    private List<Turista> turistas;

    public Viagem(String nome, String descricao, String fotoDestaque, BigDecimal preco, Integer qtdVagas) {
        this.nome = nome;
        this.descricao = descricao;
        this.fotoDestaque = fotoDestaque;
        this.preco = preco;
        this.qtdVagas = qtdVagas;
    }


    public Viagem(String nome, Organizador organizador, String descricao, String fotoDestaque, BigDecimal preco, Integer qtdVagas, ArrayList<String> pontosEmbarques, LocalDateTime dataHoraSaida, LocalDateTime dataHoraChegada) {
        this.nome = nome;
        this.organizador = organizador;
        this.descricao = descricao;
        this.fotoDestaque = fotoDestaque;
        this.preco = preco;
        this.qtdVagas = qtdVagas;
        this.pontosEmbarques = pontosEmbarques;
        this.dataHoraSaida = dataHoraSaida;
        this.dataHoraChegada = dataHoraChegada;
    }
}
