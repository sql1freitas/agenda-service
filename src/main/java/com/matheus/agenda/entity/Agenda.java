package com.matheus.agenda.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String descricao;
    @Column(name = "data_hora", nullable = false)
    private LocalDateTime horario;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;
    @ManyToOne
    private Paciente paciente;



}
