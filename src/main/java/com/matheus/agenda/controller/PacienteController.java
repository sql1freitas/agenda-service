package com.matheus.agenda.controller;

import com.matheus.agenda.DTO.PacienteAssemble;
import com.matheus.agenda.DTO.PacienteDTO;
import com.matheus.agenda.entity.Paciente;
import com.matheus.agenda.repository.PacienteRepository;
import com.matheus.agenda.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private PacienteAssemble pacienteAssemble;


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

        Optional<Paciente> pacienteId = pacienteRepository.findById(id);
        if(pacienteId.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.buscarPorID(id));
    }

    @DeleteMapping("/deletar/{id}")

    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id){

        Optional<Paciente> pacienteId = pacienteRepository.findById(id);
        if(pacienteId.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        pacienteService.deletarPaciente(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<PacienteDTO> alterarPaciente(@PathVariable Long id, @RequestBody Paciente paciente){

        Optional<Paciente> pacienteId = pacienteRepository.findById(id);
        if(pacienteId.isEmpty()){
            return ResponseEntity.notFound().build();
        }

    PacienteDTO pacienteAtualizado = pacienteService.alterarPaciente(paciente, id);

    return ResponseEntity.status(HttpStatus.OK).body(pacienteAtualizado);

    }


}
