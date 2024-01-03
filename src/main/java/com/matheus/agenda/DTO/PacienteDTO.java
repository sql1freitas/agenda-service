package com.matheus.agenda.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTO {

    private String nome;
    private String sobrenome;
    private String email;

    public PacienteDTO(String nome, String sobrenome, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;

        this.email = email;
    }


}
