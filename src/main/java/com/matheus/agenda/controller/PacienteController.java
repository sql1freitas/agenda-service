package com.matheus.agenda.controller;

import com.matheus.agenda.DTO.PacienteDTO;
import com.matheus.agenda.entity.Paciente;
import com.matheus.agenda.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;


    @PostMapping("/salvar")
    public ResponseEntity<PacienteDTO> salvarPaciente(@RequestBody Paciente paciente){

         PacienteDTO pacienteSalvo = pacienteService.salvar(paciente);

         return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);

    }
    @GetMapping("/listar-todos")
    public ResponseEntity<List<PacienteDTO>> listarTodos(){

        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.listarTodos());

    }

    @GetMapping("/listar-id/{id}")
    public ResponseEntity<List<PacienteDTO>> listarPorID(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.buscarPorID(id));
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarPaciente(@PathVariable Long id){
        pacienteService.deletarPaciente(id);
    }


}
