package com.matheus.agenda.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table
@Getter
@Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "Nome deve ser preenchido.")
    private String nome;

    @Column
    @NotBlank(message = "Sobrenome deve ser preenchido.")
    private String sobrenome;

    @Column(unique = true)
    @NotBlank(message = "CPF deve ser preenchido.")
    private String cpf;

    @Column(unique = true)
    @NotBlank(message = "Email deve ser preenchido.")
    @Email(message = "Formato de e-mail incorreto")
    private String email;
}
