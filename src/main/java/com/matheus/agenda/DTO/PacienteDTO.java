package com.matheus.agenda.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTO {

    private Long id;
    private String nome;
    private String sobrenome;

    private String cpf;

    private String email;

    public PacienteDTO(Long id, String nome, String sobrenome, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
    }


}
