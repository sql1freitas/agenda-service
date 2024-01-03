package com.matheus.agenda.DTO;

import com.matheus.agenda.entity.Paciente;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class PacienteAssemble {

    public PacienteDTO pacienteParaDTO (Paciente paciente){

        return new PacienteDTO(paciente.getId(), paciente.getNome(), paciente.getSobrenome(),
                 paciente.getEmail());
    }
}
