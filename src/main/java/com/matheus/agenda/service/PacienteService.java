package com.matheus.agenda.service;

import com.matheus.agenda.DTO.PacienteAssemble;
import com.matheus.agenda.DTO.PacienteDTO;
import com.matheus.agenda.entity.Paciente;
import com.matheus.agenda.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private PacienteAssemble pacienteAssemble;






    public PacienteDTO salvar(Paciente paciente) {


        Optional<Paciente> cpfDePaciente = pacienteRepository.findByCpfIgnoreCase(paciente.getCpf());
        Optional<Paciente> emailDePaciente = pacienteRepository.findByEmailIgnoreCase(paciente.getEmail());

        if (cpfDePaciente.isPresent()) {

            throw new RuntimeException("CPF já cadastrado em nosso sistema");

        } else if (emailDePaciente.isPresent()) {

            throw new RuntimeException("Email já cadastrado em nosso sistema");
        }

        pacienteRepository.save(paciente);

        return pacienteAssemble.pacienteParaDTO(paciente);
    }

    public List<PacienteDTO> listarTodos(){

        return pacienteRepository.findAll().stream()
                .map(paciente -> pacienteAssemble.pacienteParaDTO(paciente))
                .collect(Collectors.toList());
    }

    public List<PacienteDTO> buscarPorID(Long id){

        return pacienteRepository.findById(id).stream()
                .map(paciente -> pacienteAssemble.pacienteParaDTO(paciente))
                .collect(Collectors.toList());


    }

    public void deletarPaciente(Long id){


        pacienteRepository.deleteById(id);

    }

    public PacienteDTO alterarPaciente (Paciente paciente, Long id){



    paciente.setId(id);


    Paciente pacienteAtualizado = pacienteRepository.save(paciente);

    return pacienteAssemble.pacienteParaDTO(pacienteAtualizado);

    }






}
