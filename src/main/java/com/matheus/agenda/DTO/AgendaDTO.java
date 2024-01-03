package com.matheus.agenda.DTO;

import com.matheus.agenda.entity.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class AgendaDTO {

    private String descricao;

    private LocalDateTime horario;

    private LocalDateTime dataCriacao;

    private Paciente paciente;


    public AgendaDTO( String descricao, LocalDateTime horario, LocalDateTime dataCriacao, Paciente paciente) {
        this.descricao = descricao;
        this.horario = horario;
        this.dataCriacao = dataCriacao;
        this.paciente = paciente;
    }


}
