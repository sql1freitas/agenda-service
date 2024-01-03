package com.matheus.agenda.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @Column
    @NotBlank(message = "Descrição deve ser preenchida.")
    private String descricao;

    @Column(name = "data_hora")
    @NotBlank(message = "Horário deve ser preenchido.")
    private LocalDateTime horario;

    @Column(name = "data_criacao")
    @NotBlank(message = "Data da criação deve ser preenchida.")
    private LocalDateTime dataCriacao;

    @ManyToOne
    private Paciente paciente;



}
