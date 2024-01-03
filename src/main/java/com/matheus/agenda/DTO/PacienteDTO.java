package com.matheus.agenda.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTO {

    private Long id;
    private String nome;
    private String sobrenome;


    private String email;

    public PacienteDTO(Long id, String nome, String sobrenome, String email) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;

        this.email = email;
    }


}
