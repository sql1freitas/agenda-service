package com.matheus.agenda.controller;

import com.matheus.agenda.DTO.AgendaDTO;
import com.matheus.agenda.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
    @Autowired
    private AgendaService agendaService;


    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<AgendaDTO> listarTodos(){
       return agendaService.listarTodos();
    }


}
