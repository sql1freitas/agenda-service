package com.matheus.agenda.DTO;

import com.matheus.agenda.entity.Agenda;
import org.springframework.stereotype.Component;

@Component
public class AgendaAssemble {

    public AgendaDTO agendaParaDTO (Agenda agenda){

        return new AgendaDTO(agenda.getId(), agenda.getDescricao(), agenda.getHorario(),
                agenda.getDataCriacao(), agenda.getPaciente());
    }
}
