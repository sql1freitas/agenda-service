package com.matheus.agenda.service;

import com.matheus.agenda.DTO.AgendaAssemble;
import com.matheus.agenda.DTO.AgendaDTO;
import com.matheus.agenda.entity.Agenda;
import com.matheus.agenda.entity.Paciente;
import com.matheus.agenda.repository.AgendaRepository;
import com.matheus.agenda.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private AgendaAssemble agendaAssemble;
    @Autowired
    private PacienteService pacienteService;




    public List<AgendaDTO> listarTodos(){

        return agendaRepository.findAll().stream()
                .map(agenda -> agendaAssemble.agendaParaDTO(agenda))
                .collect(Collectors.toList());

    }


    public AgendaDTO salvar(Agenda agenda, Long id){

        Optional<Paciente> validarPaciente = pacienteRepository.findById(id);
        Optional<Agenda> validarHorario = agendaRepository.findByHorario(agenda.getHorario());

        if (validarPaciente.isEmpty()){
            throw new RuntimeException("Paciente não encontrado");
        }

        if (validarHorario.isPresent()){
            throw new RuntimeException("Horário já existe");
        }

        agenda.setPaciente(validarPaciente.get());
        agenda.setDataCriacao(LocalDateTime.now());

        Agenda newAgenda = agendaRepository.save(agenda);

        return agendaAssemble.agendaParaDTO(newAgenda);


    }

    public void deletarAgenda(Long id){

        agendaRepository.deleteById(id);

    }


    public List<AgendaDTO> buscarPorId (Long id){

        return agendaRepository.findById(id).stream()
                .map(agenda -> agendaAssemble.agendaParaDTO(agenda))
                .collect(Collectors.toList());


    }

    public List<AgendaDTO> buscarPorPaciente (String cpf){

        Optional<Paciente> validarPaciente = pacienteRepository.findByCpfIgnoreCase(cpf);

        if (validarPaciente.isEmpty()) {
            throw new RuntimeException("Paciente não encontrado");
        }

        Paciente paciente = validarPaciente.get();

        List<Agenda> agendasDoPaciente = agendaRepository.findByPaciente(paciente);

        if (agendasDoPaciente.isEmpty()) {
            throw new RuntimeException("Não existe agenda cadastrada para o CPF informado");
        }

        return agendasDoPaciente.stream()
                .map(agenda -> agendaAssemble.agendaParaDTO(agenda))
                .collect(Collectors.toList());
    }



    }
