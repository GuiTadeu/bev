package br.com.bev.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private ArrayList<String> fotos;
    private double preco;
    private LocalDateTime dataSaida;
    private LocalDateTime dataChegada;
    private ArrayList<String> pontosEmbarque;
    @OneToOne
    private Organizador organizador;
    @OneToMany
    private List<Turista> turistas;
    @OneToOne
    private Onibus onibus;

}
