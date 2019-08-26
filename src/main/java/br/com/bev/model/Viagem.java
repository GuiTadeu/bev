package br.com.bev.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Viagem {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Nome é Obrigatório")
    private String nome;

    @NotBlank(message = "Descrição é Obrigatória")
    private String descricao;

    @NotBlank(message = "Insira a URL da Imagem")
    private String fotoDestaque;

    @NotBlank(message = "Preço é Obrigatório")
    private double preco;

    @NotNull(message = "Data de Saída é Obrigatória")
    private LocalDateTime dataSaida;

    @NotNull(message = "Data de Chegada é Obrigatória")
    private LocalDateTime dataChegada;

    @NotNull(message = "Pontos de Embarque são Obrigatórios")
    private ArrayList<String> pontosEmbarque;

    @NotNull
    @ManyToOne
    private Organizador organizador;

    @NotNull
    @ManyToMany
    private List<Turista> turistas;
}
