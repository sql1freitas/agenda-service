package com.matheus.agenda.DTO;

import com.matheus.agenda.entity.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class AgendaDTO {

    private Long id;

    private String descricao;



    private LocalDateTime horario;

    private LocalDateTime dataCriacao;

    private Paciente paciente;


    public AgendaDTO(Long id, String descricao, LocalDateTime horario, LocalDateTime dataCriacao, Paciente paciente) {
        this.id = id;
        this.descricao = descricao;
        this.horario = horario;
        this.dataCriacao = dataCriacao;
        this.paciente = paciente;
    }


}
