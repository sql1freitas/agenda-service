package com.matheus.agenda.controller;

import com.matheus.agenda.DTO.AgendaDTO;
import com.matheus.agenda.entity.Agenda;
import com.matheus.agenda.repository.AgendaRepository;
import com.matheus.agenda.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
    @Autowired
    private AgendaService agendaService;
    @Autowired
    private AgendaRepository agendaRepository;


    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<AgendaDTO> listarTodos(){
       return agendaService.listarTodos();
    }

    @PostMapping("/salvar/{id}")
    public ResponseEntity<AgendaDTO> salvar(@RequestBody Agenda agenda, @PathVariable Long id){

        AgendaDTO newAgenda = agendaService.salvar(agenda, id);

        return ResponseEntity.status(HttpStatus.CREATED).body(newAgenda);

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarAgenda(@PathVariable Long id){

        Optional<Agenda> validarAgenda = agendaRepository.findById(id);

        if (validarAgenda.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


        agendaService.deletarAgenda(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @GetMapping("paciente/{cpf}")
    public ResponseEntity<AgendaDTO> encontrarPorPaciente(@PathVariable String cpf){
        AgendaDTO agenda = agendaService.buscarPorPaciente(cpf);

        return ResponseEntity.status(HttpStatus.OK).body(agenda);
    }



}
